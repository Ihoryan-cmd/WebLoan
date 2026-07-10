# SmartBank LoanApp – Test Automation Framework

Automated test suite for **SmartBank LoanApp**, built with **Java, Selenium WebDriver, and TestNG**, following the **Page Object Model (POM)** design pattern.

The framework covers the login flow, user management, and customer management modules of the application, including positive scenarios, negative/validation scenarios, and field length boundary testing.

---

## 🛠 Tech Stack

- **Java** – core language
- **Selenium WebDriver** – browser automation
- **TestNG** – test runner, assertions, data-driven testing (`@DataProvider`)
- **Page Object Model (POM)** – design pattern for maintainable, reusable page interactions
- **Maven** – dependency management and build

---

## 📁 Project Structure

```
src/test/java
├── common/           # Shared utilities (waits, config reading, helper methods)
│   ├── ConfigReader.java
│   └── LoanAppHelper.java
├── pageobjects/       # Page Object classes – one per application page
│   ├── LoginPage.java
│   ├── DashboardPage.java
│   ├── UsersPage.java
│   ├── AddUserPage.java
│   ├── CustomersPage.java
│   ├── AddCustomerPage.java
│   ├── UserFlowPages.java      # Groups related page objects for a single test flow
│   └── CustomerFlowPages.java
├── dataprovider/      # TestNG @DataProvider classes – test data separated from test logic
│   ├── LoginDataProvider.java
│   ├── UserDataProvider.java
│   └── CustomerDataProvider.java
├── BaseTest.java      # WebDriver lifecycle (@BeforeMethod / @AfterMethod), shared config/helper instances
├── Login.java         # Reusable login flow wrapper used across multiple test classes
├── LoginTest.java      # Login test scenarios
├── Users.java          # User creation/management test scenarios
└── Customers.java      # Customer creation/management test scenarios
```

**Design notes:**
- All locators and `WebDriver` interactions are encapsulated inside Page Object classes — test classes never call `driver.findElement()` directly.
- Common navigation flows (e.g. logging in and reaching the "Add User" page) are extracted into reusable methods to avoid duplication across test methods.
- Test data is separated from test logic via TestNG `@DataProvider` classes.

---

## ⚙️ Setup

### 1. Clone the repository
```bash
git clone https://github.com/Ihoryan-cmd/WebLoan.git
```

### 2. Configure credentials
This project keeps credentials and environment settings **out of source control**. Before running tests, create a `config.properties` file inside `src/main/resources/`:

```properties
url=https://qa.hitekschool.com/lms/3108/login
branch=YourBranchName
username=YourUsername
password=YourPassword
```

> `config.properties` is git-ignored — you must create it locally. Values above are placeholders; use valid test-environment credentials.

### 3. Install dependencies
```bash
mvn clean install
```

---

## ▶️ Running the tests

Run all tests via Maven:
```bash
mvn test
```

Or run individual test classes (`LoginTest`, `Users`, `Customers`) directly from your IDE.

---

## ✅ Test Coverage

**Login**
- Valid login with correct credentials
- Empty required fields (branch, username, password) — validation messages
- Invalid branch / username / password — error messages

**Users**
- Create user with valid data
- Empty required fields — validation messages
- Duplicate username handling
- Field format validation (phone, email, name characters)
- Field max-length boundaries

**Customers**
- Create customer with valid data
- Required field validation
- Duplicate account number handling
- Field format validation (phone, email, name characters)
- Field max-length boundaries

---
## 🧪 Manual Testing Artifacts

In addition to automation, this repository includes manually designed test cases and documented bug reports created during manual testing of the application using structured test design techniques such as Equivalence Partitioning and Boundary Value Analysis.

**Test Cases** ([`TestCases/`](./TestCases)) — covering Login, Add User, and Add Customer pages:
- [Login test cases](./TestCases/Login.md)
- [Add User test cases](./TestCases/AddUser.md)
- [Add Customer test cases](./TestCases/AddCustomer.md)

**Bug Reports** ([`BugReports/`](./BugReports)) — selected defects including steps to reproduce, expected and actual results, severity, priority, and business impact.

## 🔮 Possible future improvements

- Allure reporting for richer test result visualization
- Log4j integration for structured logging
- Parallel test execution
