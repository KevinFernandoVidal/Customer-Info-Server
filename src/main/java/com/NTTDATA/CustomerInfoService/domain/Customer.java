package com.NTTDATA.CustomerInfoService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Customer {
    private Integer documentNumber;
    private DocumentType documentType;
    private String firstName;
    private String middleName;
    private String firstSurname;
    private String secondSurname;
    private String telephone;
    private String address;
    private String hometown;
}
