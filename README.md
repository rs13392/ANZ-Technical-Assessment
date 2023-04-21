# Selenium Java - Cucumber Framework - For ANZ Technical Assessment.

---

## Project Purpose
This project aims to showcase the capbility by developing the automation framework that uses Selenium, Cucumber, TestNG with Java as the programming language.

---

## Tools and Libraries
This project using 3 main tools, Selenium Cucumber and TestNG.
The complete list of tools, you can see in the `pom.xml` file.

## Prerequisites
* Java Development Kit
* Maven
* Selenium WebDriver
* Cucumber BDD
* TestNG



## Running Tests
* Clone the repository from your fork to this directory
* Open the project using any Java IDE - Intellij or Eclipse
* Run all the tests with the below command using TestNG 
```shell
$ mvn clean test -DsuiteXmlFile=testng.xml 
```
* If you want to run all the test using Cucumber, Use the below command
```shell
$ mvn clean test
```
* If you want to run the test with a specific tag using Cucumber, Use the below command
```shell
$ mvn clean test -Dcucumber.options="--tags @<replace this text with a tag. Eg. regression, smoke>"
```


## Test Results
* Test report automatically generated on `target` folder after finished the test execution
* See test report from `target/cucumber-reports/advanced-reports/cucumber-html-reports/overview-features.html`
* You can also share your Cucumber Report with another person at https://reports.cucumber.io, just go to `src/test/resources/cucumber.properties` then change the value to be `true`
```properties
cucumber.publish.enabled=true
```

NOTE: Test Reports are found temporarily in the below URL for 24 Hours
https://reports.cucumber.io/reports/b925ac0e-7d3a-4ec5-bb5b-663c064dd260
This report will self-destruct in 24h.
