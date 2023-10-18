package com.NTTDATA.CustomerInfoService.infrastructure.mapper;

import com.NTTDATA.CustomerInfoService.domain.Customer;
import com.NTTDATA.CustomerInfoService.infrastructure.entity.CustomerEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    @Mappings(
            {
                    @Mapping(source= "documentNumber", target = "documentNumber"),
                    @Mapping(source= "documentType", target = "documentType"),
                    @Mapping(source= "firstName", target = "firstName"),
                    @Mapping(source= "middleName", target = "middleName"),
                    @Mapping(source= "firstSurname", target = "firstSurname"),
                    @Mapping(source= "secondSurname", target = "secondSurname"),
                    @Mapping(source= "telephone", target = "telephone"),
                    @Mapping(source= "address", target = "address"),
                    @Mapping(source = "hometown", target = "hometown")
            }

    )
    Customer toCustomer(CustomerEntity customerEntity);

    @InheritInverseConfiguration
    CustomerEntity toCustomerEntity(Customer customer);
}
