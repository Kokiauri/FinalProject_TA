# Test Automation Final Project 

## Group members & Contributions
- Kokiauri Giorgi

All Tests/Presentation etc. are done by me.

## Prerequisites

- **Java JDK 21**: Though I had Java 25 installed and it worked fine
- **Maven** 
- **FirefoxDriver**: I decided to use firefox due to ads on the site.
- I also have ChromeDriver imported, if Firefox is not installed, the only place it needs to be changed is in **\utils\DriverFactory**

## Project Structure

- `src/main/java/pages`: Page Object classes for UI tests.
- `src/main/java/base`: Base classes for API and UI test setup.
- `src/main/java/utils`: Utility classes like `DriverFactory`.
- `src/test/java/org/example/ui`: UI test cases.
- `src/test/java/org/example/api`: API test cases.
- `testng.xml`: Configuration for running test suites.

## Running Tests

### 1. Run All Tests
To run all 20 tests, as defined in `testng.xml`:
```bash
mvn clean test
```

### 2. Run Specific Test Class
To run a specific test class (e.g., `ProductsTests`):
```bash
mvn test -Dtest=ProductsTests
```


## Generating Reports

### 1. Generate Allure Results
Running the tests automatically generates raw results in the `target/allure-results` directory.

### 2. View Allure Report
After running the tests, you can generate and open the report using the following Maven command:
```bash
mvn allure:serve
```

### 3. Generate Static Report
To generate a static HTML report in the `target/site/allure-maven-plugin` directory:
```bash
mvn allure:report
```
