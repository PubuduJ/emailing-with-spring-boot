# Emailing With Spring Boot <img src="assets/logo.png" alt="drawing" width="27px"/>

This project was developed using the **Spring Boot framework** with **n-tier architecture** to understand and improve on that
Knowledge of the **email sending feature** in Spring Boot.
In this project, **user web service** is exposed as an **API** under the **users** resource and more information on the user web 
service with example test cases can be found in the below API documentation.

#### Highlighted features of the application,



#### Few snapshots of the documentation

- Transaction got rolled back.<br>

<img src="assets/roll-back.png" alt="splash-screen" width="800px"/>

#### ERD of the database

<img src="assets/ERD.png" alt="erd" width="600px"/>

## Used Technologies

- Java SE 11
- Spring Boot 2.7.8
- Apache Maven 3.8.6
- MySQL Community Server 8.0.31
- Added dependencies to pom.xml
    - spring-boot-starter-web 2.7.8
    - spring-boot-starter-validation 2.7.8
    - spring-boot-starter-data-jpa 2.7.8
    - spring-boot-starter-aop 2.7.8
    - spring-boot-starter-mail 2.7.8
    - spring-boot-starter-test 2.7.8
    - spring-boot-devtools
    - lombok 1.18.24
    - mysql-connector-j 8.0.31
    - modelmapper 3.1.0

#### Used Integrated Development Environment
- IntelliJ IDEA

## How to use ?
This project can be used by cloning the 
project to your local computer.

Make sure to create a **user_app_db** database in the MySQL community server.
If neglect to create, the project will automatically generate it when it is firstly executed.

#### Clone this repository
1. Clone the project using `https://github.com/PubuduJ/emailing-with-spring-boot.git` terminal command.
2. Open the `pom.xml` file from **IntelliJ IDEA**, make sure to open this as a project.
3. Change the `spring.datasource.password` in the `application.properties` to your local machine MySQL server password.
4. Give the values for `spring.mail.username` and `spring.mail.password` from your `Sendinblue` **SMTP Server** account.

## Version
v1.0.0

## License
Copyright &copy; 2023 [Pubudu Janith](https://www.linkedin.com/in/pubudujanith/). All Rights Reserved.<br>
This project is licensed under the [MIT license](LICENSE.txt).