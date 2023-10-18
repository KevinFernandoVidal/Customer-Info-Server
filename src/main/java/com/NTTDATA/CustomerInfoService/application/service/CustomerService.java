package com.NTTDATA.CustomerInfoService.application.service;

import com.NTTDATA.CustomerInfoService.application.repository.CustomerRepository;
import com.NTTDATA.CustomerInfoService.domain.Customer;
import com.NTTDATA.CustomerInfoService.domain.DocumentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public Customer getCustomerByDocumentTypeAndDocument(DocumentType documentType, Integer document){
        return customerRepository.findCustomerByDocumentTypeAndDocumentNumber(documentType, document);
    }
}
