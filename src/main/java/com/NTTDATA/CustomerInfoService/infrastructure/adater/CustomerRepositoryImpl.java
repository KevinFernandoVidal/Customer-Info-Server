package com.NTTDATA.CustomerInfoService.infrastructure.adater;

import com.NTTDATA.CustomerInfoService.application.repository.CustomerRepository;
import com.NTTDATA.CustomerInfoService.domain.Customer;
import com.NTTDATA.CustomerInfoService.domain.DocumentType;
import com.NTTDATA.CustomerInfoService.infrastructure.mapper.CustomerMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    private CustomerCrudRepository customerCrudRepository;
    private CustomerMapper customerMapper;

    public CustomerRepositoryImpl(CustomerCrudRepository customerCrudRepository, CustomerMapper customerMapper) {
        this.customerCrudRepository = customerCrudRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public Customer findCustomerByDocumentTypeAndDocumentNumber(DocumentType documentType, Integer documentNumber) {
        return customerMapper.toCustomer(customerCrudRepository.findByDocumentTypeAndDocumentNumber(documentType,documentNumber));
    }
}
