# REST Assured API Automation Framework

A simple API automation framework built using **Java, REST Assured, TestNG, Maven, and Allure**.

The framework is designed for API testing practice and demonstrates a clean, reusable structure suitable for automation projects and QA interviews.

## Tech Stack

* Java
* REST Assured
* TestNG
* Maven
* Allure Report
* JSON Test Data

## Project Structure

```text
APIAuto/
│
├── pom.xml
├── testng.xml
├── README.md
│
├── allure-results/
├── allure-report/
│
└── src/
    ├── main/
    │   ├── java/
    │   │   └── framework/
    │   │       ├── config/
    │   │       │   └── ConfigReader.java
    │   │       ├── core/
    │   │       │   └── RequestSpec.java
    │   │       ├── services/
    │   │       │   ├── AuthService.java
    │   │       │   └── BookingService.java
    │   │       └── utils/
    │   │           ├── TestDataReader.java
    │   │           └── AllureUtils.java
    │   │
    │   └── resources/
    │       └── config.properties
    │
    └── test/
        ├── java/
        │   ├── base/
        │   │   └── BaseTest.java
        │   └── tests/
        │       └── BookingTest.java
        │
        └── resources/
            └── testdata/
                └── booking.json
```

## Framework Design

The framework uses a service-based structure for API endpoints.

```text
Test Class
    ↓
BaseTest
    ↓
Service Layer
    ↓
Request Specification
    ↓
REST API
```

### Main Components

**BaseTest**

Initialises common services used by the tests.

**BookingService**

Contains booking API operations such as:

* Get all bookings
* Get booking by ID
* Create booking
* Delete booking

**AuthService**

Handles authentication and token generation.

**RequestSpec**

Contains common API configuration such as:

* Base URL
* Content Type
* Accept Header

**TestDataReader**

Reads JSON test data from the test resources folder.

**AllureUtils**

Attaches API requests and responses to Allure reports.

## Test Data

Test data is stored separately from the test code.

```text
src/test/resources/testdata/booking.json
```

This allows test data to be changed without modifying the test logic.

## Tests

Current tests cover:

* Get all bookings
* Create a booking
* Get booking details by ID

The `getBookingById` test creates a booking first and then uses the generated booking ID to retrieve it.

## Run Tests

Run all tests using Maven:

```bash
mvn clean test
```

## Allure Report

Test results are generated in:

```text
allure-results/
```

Generate the HTML report:

```bash
allure generate allure-results -o allure-report --clean
```

Open the report:

```bash
allure open allure-report
```

The generated report is stored separately in:

```text
allure-report/
```

## Configuration

The API base URL is maintained in:

```text
src/main/resources/config.properties
```

Example:

```properties
base.url=https://restful-booker.herokuapp.com
```

## Author

**Harshana Premarathna**


