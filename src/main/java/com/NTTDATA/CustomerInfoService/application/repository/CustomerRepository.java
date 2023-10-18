package com.NTTDATA.CustomerInfoService.application.repository;

import com.NTTDATA.CustomerInfoService.domain.Customer;
import com.NTTDATA.CustomerInfoService.domain.DocumentType;

public interface CustomerRepository {
    Customer findCustomerByDocumentTypeAndDocumentNumber(DocumentType documentType,Integer documentNumber);
}
