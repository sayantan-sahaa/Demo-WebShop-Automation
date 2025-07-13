# Demo Web Shop Automation Framework

A comprehensive test automation framework for the [Demo Web Shop](https://demowebshop.tricentis.com/) application using Selenium WebDriver, TestNG, and Cucumber.

## 🚀 Framework Overview

This framework combines the power of Selenium WebDriver with TestNG and Cucumber to provide a robust, scalable, and maintainable test automation solution. It follows the Page Object Model (POM) design pattern and supports both BDD (Behavior Driven Development) and traditional test automation approaches.

## 🏗️ Framework Architecture

```
Demo-WebShop-Automation/
├── src/
│   ├── main/
│   │   ├── base/                    # WebDriver management
│   │   │   ├── Base.java           # Firefox driver implementation
│   │   │   ├── DriverManager.java  # Driver interface
│   │   │   └── DriverManagerFactory.java
│   │   └── reporting/
│   │       └── ExtentReportUtil.java # Extent reporting utilities
│   └── test/
│       ├── datamodels/             # Data transfer objects
│       │   └── LoginCredential.java
│       ├── features/               # Cucumber feature files
│       │   └── Login.feature
│       ├── hooks/                  # Test lifecycle management
│       │   └── Hooks.java
│       ├── listeners/              # Custom listeners
│       │   ├── Listener.java
│       │   ├── ScreenShotUtil.java
│       │   └── TestNGListener.java
│       ├── pages/                  # Page Object classes
│       │   ├── HomePage.java
│       │   └── LoginPage.java
│       ├── steps/                  # Step definitions & test classes
│       │   ├── HomeStep.java
│       │   └── LoginSteps.java
│       ├── utils/                  # Utility classes
│       │   ├── Asserts.java
│       │   ├── CommonUtils.java
│       │   └── TestDataReader.java
│       └── Runner.java             # Cucumber test runner
├── screenshots/                    # Screenshot storage
├── build.gradle                    # Build configuration
└── readme.md
```

## 🛠️ Technologies Used

- **Java 21** - Programming language
- **Selenium WebDriver 4.33.0** - Web automation
- **TestNG** - Test execution framework
- **Cucumber** - BDD framework
- **ExtentReports** - Advanced reporting
- **Gradle** - Build automation
- **Firefox WebDriver** - Browser automation
- **Jackson** - JSON data handling

## ✨ Key Features

### 🎯 Multi-Framework Support
- **TestNG Integration**: Direct test execution with annotations
- **Cucumber BDD**: Gherkin syntax for behavior-driven testing
- **Hybrid Approach**: Supports both traditional and BDD testing

### 🏗️ Design Patterns
- **Page Object Model (POM)**: Maintainable page representations
- **Factory Pattern**: Dynamic driver creation
- **Singleton Pattern**: Single WebDriver instance management
- **ThreadLocal**: Thread-safe parallel execution support

### 📊 Advanced Reporting
- **ExtentReports**: Rich HTML reports with screenshots
- **TestNG Reports**: Built-in test execution reports
- **Cucumber Reports**: BDD-style feature reports
- **Screenshot Capture**: Automatic failure screenshots

### 🔧 Test Management
- **WebDriver Lifecycle**: Automated setup and teardown
- **Page Element Initialization**: Dynamic page factory implementation
- **Soft Assertions**: Non-blocking assertion support
- **Cross-Browser Support**: Extensible driver management

## 🚦 Getting Started

### Prerequisites
- Java 21 or higher
- Gradle 8.14.1+
- Firefox browser installed
- Git (for version control)

### Installation & Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Demo-WebShop-Automation
   ```

2. **Install dependencies**
   ```bash
   ./gradlew build
   ```

3. **Verify setup**
   ```bash
   ./gradlew test --tests steps.HomeStep.getTitle
   ```

## 🧪 Running Tests

### TestNG Tests
```bash
# Run all tests
./gradlew test

# Run specific test class
./gradlew test --tests steps.LoginSteps

# Run specific test method
./gradlew test --tests steps.LoginSteps.completeLoginFlow

# Run by test groups
./gradlew test -Dgroups=Login
```

### Cucumber Tests
```bash
# Run Cucumber tests via Runner
./gradlew test --tests Runner

# Run with specific tags
./gradlew test -Dcucumber.filter.tags="@smoke"
```

### Gradle Commands
```bash
# Clean build
./gradlew clean build

# Run tests with reports
./gradlew clean test

# Generate test reports only
./gradlew test --rerun-tasks
```

## 📋 Test Scenarios

### Current Test Coverage

#### 🏠 Home Page Tests
- **Title Verification**: Validates page title is "Demo Web Shop"
- **Navigation Elements**: Verifies header links and menu items
- **Search Functionality**: Tests search box and button interactions

#### 🔐 Login Tests
- **Successful Login**: Valid credentials login flow
- **Failed Login Scenarios**:
  - Invalid email address
  - Invalid password
  - Empty form fields
- **UI Element Validation**: Login form components

### 📝 Feature Files
Located in `src/test/features/`, written in Gherkin syntax:

```gherkin
Feature: Login Functionality
  Scenario: Successful login with valid credentials
    Given the user is on the Demo Web Shop login page
    When the user enters valid email address
    And the user enters valid password
    And the user clicks on the login button
    Then the user should be logged in successfully
```

## 🔧 Configuration

### Browser Configuration
Configure browser settings in [`Base.java`](src/main/base/Base.java):
```java
public class Base implements DriverManager {
    @Override
    public WebDriver createDriver() {
        return new FirefoxDriver(); // Can be extended for other browsers
    }
}
```

### Test Data Management
- **JSON Configuration**: Test data stored in `src/testdata.json`
- **Data Models**: Type-safe data objects in `datamodels/` package
- **Environment Variables**: Support for different test environments

### Reporting Configuration
Extent Reports configuration in [`ExtentReportUtil.java`](src/main/reporting/ExtentReportUtil.java):
- **Report Location**: `target/ExtentReport.html`
- **Theme**: Standard theme with custom branding
- **Screenshots**: Automatic capture on failures

## 🏗️ Framework Components

### 🌐 Page Objects
Example from [`HomePage.java`](src/test/pages/HomePage.java):
```java
@FindBy(css = "a.ico-login")
public static WebElement loginURL;

@FindBy(id = "small-searchterms")
public static WebElement searchBox;
```

### 🔗 Step Definitions
Example from [`LoginSteps.java`](src/test/steps/LoginSteps.java):
```java
@Given("the user is on the Demo Web Shop login page")
public void clickLoginURL() {
    loginURL.click();
}

@When("the user enters valid email address")
public void enterValidEmail() {
    email.sendKeys("test@example.com");
}
```

### 🎯 Test Hooks
Lifecycle management in [`Hooks.java`](src/test/hooks/Hooks.java):
```java
@BeforeSuite
public static void setUp() {
    // WebDriver initialization with listeners
}

@AfterSuite
public static void tearDown() {
    // Cleanup and report generation
}
```

## 📊 Reporting & Logs

### 📈 Report Types
1. **Extent Reports**: `target/ExtentReport.html`
   - Rich HTML reports with screenshots
   - Test execution timeline
   - System information

2. **TestNG Reports**: `build/reports/tests/test/index.html`
   - Standard TestNG execution reports
   - Test success/failure statistics

3. **Cucumber Reports**: `target/cucumber-reports/`
   - BDD-style feature reports
   - Step-by-step execution details

### 📷 Screenshot Management
- **Automatic Capture**: On test failures
- **Manual Capture**: Using [`ScreenShotUtil.takeScreenShot()`](src/test/listeners/ScreenShotUtil.java)
- **Storage Location**: `screenshots/` directory
- **Naming Convention**: `{stepName}.png`

## 🔧 Utilities & Helpers

### 🛠️ Assertion Utilities
[`Asserts.java`](src/test/utils/Asserts.java) provides:
- **Hard Assertions**: Immediate test failure
- **Soft Assertions**: Collect multiple failures
- **Custom Assertions**: Extended validation methods

### 📋 Common Utilities
[`CommonUtils.java`](src/test/utils/CommonUtils.java) includes:
- **Element Interactions**: Click, scroll, wait operations
- **Data Handling**: File operations, property reading
- **Browser Operations**: Navigation, window management

### 📖 Test Data Reader
[`TestDataReader.java`](src/test/utils/TestDataReader.java) features:
- **JSON Parsing**: Structured test data
- **Dynamic Loading**: Runtime data access
- **Type Safety**: Strongly-typed data models

## 🏃‍♂️ Execution Examples

### 🎯 Quick Test Run
```bash
# Run login functionality tests
./gradlew test --tests "steps.LoginSteps"

# Run with specific browser (when extended)
./gradlew test -Dbrowser=chrome

# Run with environment configuration
./gradlew test -Denv=staging
```

### 📊 Generate Reports
```bash
# Run tests and open reports automatically
./gradlew test && open build/reports/tests/test/index.html

# View Extent Reports (if generated)
open target/ExtentReport.html
```

## 🔄 CI/CD Integration

### GitHub Actions Example
```yaml
name: Automation Tests
on: [push, pull_request]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v3
      - uses: actions/setup-java@v3
        with:
          java-version: '21'
      - name: Run Tests
        run: ./gradlew test
      - name: Upload Reports
        uses: actions/upload-artifact@v3
        with:
          name: test-reports
          path: build/reports/
```

## 🤝 Contributing

### 📝 Adding New Tests
1. **Create Page Objects**: Add elements in `pages/` package
2. **Write Step Definitions**: Implement in `steps/` package
3. **Create Feature Files**: Add scenarios in `features/`
4. **Update Test Data**: Modify `testdata.json` if needed

### 🐛 Best Practices
- **Element Locators**: Prefer ID > CSS > XPath
- **Wait Strategies**: Use explicit waits over Thread.sleep()
- **Page Objects**: Keep methods focused and reusable
- **Test Data**: Externalize test data from code
- **Assertions**: Use appropriate assertion types

## 🔍 Troubleshooting

### ❗ Common Issues

1. **WebDriver Issues**
   ```
   Error: WebDriver not initialized
   Solution: Ensure setUp() is called before tests
   ```

2. **Element Not Found**
   ```
   Error: NoSuchElementException
   Solution: Check locator strategies and wait conditions
   ```

3. **Compilation Errors**
   ```
   Error: Cannot resolve symbol
   Solution: Run ./gradlew clean build
   ```

### 🐞 Debug Mode
```bash
# Run with debug logging
./gradlew test --debug

# Run single test with verbose output
./gradlew test --tests "LoginSteps" --info
```

## 📞 Support & Maintenance

### 📧 Contact Information
- **Framework Maintainer**: Sayantan Saha
- **Test Environment**: Demo Web Shop (Tricentis)
- **Framework Version**: 1.0.0

### 🔄 Update Guidelines
- **Dependencies**: Keep Selenium and TestNG updated
- **Browser Drivers**: Use WebDriverManager for auto-updates
- **Java Version**: Maintain compatibility with Java 21+

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

**Happy Testing! 🚀**

> This framework provides a solid foundation for web automation testing with modern tools and best practices. Feel free to extend and customize according to your