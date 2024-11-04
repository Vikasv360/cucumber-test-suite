# Selenium Web automation(UI) using Cucumber BDD framework
## Overview

This repository contains an Selenium testing framework built using Cucumber and TestNG. This approach allows for clear and concise test definitions, making it easier to understand and maintain tests.

## Technologies Used

- **Cucumber**: A tool for running automated tests written in plain language.
- **Selenium**: A browser automation tool.
- **Java**: Programming language used for writing test code.
- **TestNG**: Dependencies used building the framework.
- **Maven**: Build automation tool for managing project dependencies and building the project.

## Prerequisites
To run the tests, ensure you have the following installed:

- **Java Development Kit (JDK) 8 or higher**
- **Maven**
- **Cucumber**
- **TestNG**
- **Browser Driver**

## Writing Tests
1. **Project structure**:
- **\src\main\java** > Files package which consists of all the required request payload in the form of POJO classes ( for serialization ).
 
- **\src\test\java** >
  
  **Features package**: consists of feature file which has all API test scenarios.
  
  **resources package**: Consists of Utility class(), TestDataBuild class(), global property file.
  
  **stepDefinitions package**: Consists of Stepdefinition class which has all the working code.
  
  **testRunner package**: Consists of TestNGTestRunner class which extends AbstractTestNGCucumberTests abstract class(dependent on TestNG dependency)

2. **Dependencies used**:
- **Cucumber java** 
- **Cucumber TestNG** 
- **cucumber-picocontainer** 
- **extentreports**
- **extentreports-cucumber7-adapter**
- **extentreports**
- **commons-io**
- **logback-classic**

3. **API documentation source**
   
   https://github.com/vdespa/introduction-to-postman-course/blob/main/simple-books-api.md



