# G1B6_BED_GradedProject4
## This repository consists of the code for Employee Management REST API with Spring Security 
### You are required to create a Employee Management Rest Api based Web application, where you will be developing CRUD(Create,Read,Update and Delete) functionality along with Sorting and some concepts of security.Your Rest Api should be secure.And should have different endpoints for different operations

* This is a Spring REST APIs Project built using Spring Boot.
* The project is in 'SpringSecurityRest' folder in this repo
* The main package is : com.glearning.SpringSecurityRest which conatins the driver class of the application.
* The URL to access the application is : 
* There are 6 sub-packages :
    * com.glearning.SpringSecurityRest.model - the entity class
    * com.glearning.SpringSecurityRest.doa - contains an interface which extends JpaRepository for database related operations in spring
    * com.glearning.SpringSecurityRestt.service - which will has an Interface containing the methods used in service implementation.
    * com.glearning.SpringSecurityRestt.serviceimpl - which has an implementation class of service interface. Here the JpaRepository methods are used for                                                               different CRUD operations required by the use case.
    * com.glearning.SpringSecurityRest.controller - which will have url mappings to perfom different CRUD functionalities in the UI.
    * com.glearning.SpringSecurityRest.security - This contains the Role-Based Authorization code.
    * **com.glearning.SpringSecurityRest.testdata -This is the additional package which conatins a set of dummy employees, which will load on application start**
* The database used in the Project is MYSQL Database. **PLEASE ENTER YOU OWN MYSQL PASSWORD in application.properties**.
* The name of the database we use in the project is 'empsecuritydb', use the same or create you own database for using this application. 
