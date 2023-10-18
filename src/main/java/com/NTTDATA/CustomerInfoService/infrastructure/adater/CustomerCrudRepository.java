package com.NTTDATA.CustomerInfoService.infrastructure.adater;

import com.NTTDATA.CustomerInfoService.domain.DocumentType;
import com.NTTDATA.CustomerInfoService.infrastructure.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerCrudRepository extends JpaRepository<CustomerEntity, Integer> {


    CustomerEntity findByDocumentTypeAndDocumentNumber(DocumentType documentType, Integer documentNumber);

}
