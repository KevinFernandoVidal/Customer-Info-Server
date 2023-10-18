package com.NTTDATA.CustomerInfoService.infrastructure.controller;

import com.NTTDATA.CustomerInfoService.application.service.CustomerService;
import com.NTTDATA.CustomerInfoService.domain.Customer;
import com.NTTDATA.CustomerInfoService.domain.DocumentType;
import com.NTTDATA.CustomerInfoService.infrastructure.exception.BadRequestException;
import com.NTTDATA.CustomerInfoService.infrastructure.exception.InternalServerErrorException;
import com.NTTDATA.CustomerInfoService.infrastructure.exception.NotFoundException;
import jakarta.annotation.Nonnull;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/search/{documentType}-{documentNumber}")
    public ResponseEntity<Customer> getByDocument(
            @PathVariable("documentType") @Nonnull DocumentType documentType,
            @PathVariable("documentNumber") @Nonnull int documentNumber){
        if (documentType == null|| documentNumber <= 10000){
            log.info("Missing data in the requirement");
            throw new BadRequestException("C-400","Document type and document number are required");
        }
        Customer custumer;
        try {
            custumer = customerService.getCustomerByDocumentTypeAndDocument(documentType, documentNumber);
            if (custumer== null){
                log.info("Customer not found with documeto: {}", documentNumber);
                throw new NotFoundException("C-404","Consumer was not found");
            }
        } catch (DataAccessException e) {
            log.error("It gets error: {}", e.getMostSpecificCause().getMessage());
            throw new InternalServerErrorException("C-500","The database is not accessible");
        }
        log.info("The client was found with documeto: {}", documentNumber);
        return ResponseEntity.ok(custumer);
        }
}
