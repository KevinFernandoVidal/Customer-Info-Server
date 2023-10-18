# Customer Information Service

This is a REST service that allows you to consult the basic information of a customer. Provides information about clients identified by their type and document number.

## Features

- Consult basic customer information by type and document number. 
- Returns data such as first name, middle name, first surname, second surname, telephone, address and city of residence.

## requirements

- Java 17
- Maven
- Spring Boot

## Run 
1. Download this project. 
2. Open a terminal in the project root directory. 
3. Run the application with Maven:

   ```bash
   mvn spring-boot:run
   ```
The application will run on port 8090.
 
 ## Use
To query a client’s information, make an HTTP GET request to the following URL:

   ```json
   http://localhost:8090/api/customer/{documentType}-{documentNumber}
   ```
Replace documentType with 'C' if document type is ID or 'P' if Passport and documentNumber by document number

## Author
Kevin Fernando vidal Mina
