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

->Future Improvements
These limitations are identified areas for improvement. They will be addressed in upcoming versions to improve test reliability, stability, and execution consistency.

Note: The project is actively being improved, and future releases will include these enhancements.
