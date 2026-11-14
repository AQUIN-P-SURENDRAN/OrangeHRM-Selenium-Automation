# OrangeHRM-Selenium-Automation
End-to-end OrangeHRM automation testing project using Selenium WebDriver, Java, TestNG, Maven and Page Object Model (POM).


How to run this project?
To run this project in your system you need some certain tools ,required environment and dependencies.

Requirement	Purpose
Java JDK->Run Java code
Eclipse or IntelliJ IDEA->Open and manage the project (optional IDE)
Maven->Manage project dependencies
Selenium WebDriver->Browser automation
TestNG->Execute test cases
Chrome browser->Run browser tests
Internet connection->Access OrangeHRM demo website

!: Important Notice – Current Project Limitations (V2)

The current V2 release is functional, but a few test scenarios require specific preconditions to execute successfully. Some modules may not pass consistently until the following conditions are met.

Before executing the complete test suite, please ensure:
1. Employee ID: Use a unique Employee ID for each test execution to avoid duplicate-record conflicts.
2. Employee Name: Ensure the employee name used in the test data does not conflict with existing records.
3. Leave Module: Apply for or configure the necessary leave entitlement for the test employee in the OrangeHRM application before executing leave-related test cases.

🧪 Test Coverage
This project covers multiple functional modules of the OrangeHRM application using Selenium WebDriver and Java.

The following test scenarios have been automated:

| Module | Test Scenarios |
|---|---|
| Login | Valid login and authentication |
| Negative Login | Invalid login credentials and error validation |
| Dashboard | Dashboard heading, menu items and profile verification |
| PIM | Employee management and employee-related operations |
| Employee File Upload | Upload employee-related files |
| Delete Employee | Employee deletion functionality |
| Leave Management | Leave module functionality |
| Logout | Logout functionality and redirection to login page |

Automation Framework
- Design Pattern: Page Object Model (POM)
- Test Framework:  TestNG
- Browser Automation: Selenium WebDriver
- Test Data: Excel / CSV
- Reporting: ExtentReports
- Failure Handling: Automatic screenshot capture using TestNG Listeners

-> Project Structure
The project follows the Page Object Model (POM) design pattern to maintain a structured and reusable automation framework.
OrangeHRM-Selenium-Automation/
│
├── src/
│   ├── main/java/
│   │   └── com.orangehrm/
│   │       ├── base/
│   │       │   └── orangebase.java
│   │       │
│   │       ├── pages/
│   │       │   ├── OrangeLogin.java
│   │       │   ├── orangeDashboard.java
│   │       │   ├── OrangePIMpage.java
│   │       │   ├── PIMFileUpload.java
│   │       │   └── PIMLeaveapply.java
│   │       │
│   │       ├── utilities/
│   │       │   └── LoginDataProvider.java
│   │       │
│   │       └── listeners/
│   │           └── TestListener.java
│   │
│   └── test/java/
│       └── com.orangehrm.tests/
│           ├── LoginTest.java
│           ├── NegativeLoginTest.java
│           ├── DashboardTest.java
│           ├── PIMTest.java
│           ├── PIMFileuploadTest.java
│           ├── DeleteEmployeeTest.java
│           └── LeaveTest.java
│
├── fileupload/
│   ├── importData.csv
│   └── EMPimage.jpg
│
├── reports/
├── screenshots/
│
├── pom.xml
├── testng.xml
└── .gitignore


Note: `reports/` and `screenshots/` are generated during test execution and are excluded from Git using `.gitignore`.

->Future Improvements
These limitations are identified areas for improvement. They will be addressed in upcoming versions to improve test reliability, stability, and execution consistency.

Note: The project is actively being improved, and future releases will include these enhancements.
