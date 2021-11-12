# Poseidon
An API with 5 entities + 1 user entity. 
This app uses Java to run and stores the data in Mysql DB.
A securised webapp to access CRUD operations.



## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.


### Prerequisites

What things you need to install the software and how to install them

- Java 11
- SpringBoot 2.5.5
- Mysql 8.0.17


### Running App

Post installation of MySQL, Java and Maven, you will have to set up the tables and data in the data base.
For this, please run the sql commands present in the `data.sql` file under the `resources` folder in the code base.

Finally, you will be ready to import the code into an IDE of your choice and run the App.java to launch the application.


## Logging

The webapp controllers are logged useing Log4j API



## Testing

The API has a Jacoco test coverage of 96 %
The webapp has a Jacoco test coverage of 93 %

To run the tests from maven, go to the folder that contains the pom.xml file and execute the below command.

`mvn test`
