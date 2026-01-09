# OpenCart Automation Test Suite
📌 Overview

This repository contains an enterprise-grade automation framework designed to test the OpenCart e-commerce application across UI and API layers.
The framework is built with scalability, maintainability, and CI/CD readiness in mind, simulating real-world automation challenges found in production systems.

The goal of this project is not just test execution, but to demonstrate:

Framework architecture

Test design principles

Reliability handling

CI/CD integration

Realistic end-to-end workflows

🏗 Application Under Test (AUT)

OpenCart is an open-source e-commerce platform that closely resembles enterprise retail applications.

Why OpenCart?

Admin & Customer roles

Authentication & authorization

Product, cart, order workflows

CRUD-heavy business logic

| Category        | Tool                    |
| --------------- | ----------------------- |
| Language        | Java                    |
| UI Automation   | Selenium WebDriver      |
| API Automation  | REST Assured            |
| BDD Framework   | Cucumber                |
| Test Runner     | TestNG                  |
| Build Tool      | Maven                   |
| Design Pattern  | Page Object Model (POM) |
| Reporting       | Allure Reports          |
| Logging         | Log4j                   |
| CI/CD           | GitHub Actions          |
| Version Control | Git                     |


opencart-automation-suite


<img width="294" height="573" alt="image" src="https://github.com/user-attachments/assets/a67488b4-a7e3-4241-9b15-e0d59309fd97" />


🧠 Framework Design Highlights
✔ BDD with Cucumber

Feature files written in Gherkin

Business-readable scenarios

Strong collaboration between QA, Dev, and Product

Step definitions mapped to reusable actions

Example:
Scenario: Successful order placement by registered user
  Given user is logged into OpenCart
  When user adds a product to cart
  And completes checkout
  Then order should be created successfully

✔ Page Object Model (POM)

Page actions separated from step definitions

Improves reusability and readability

Simplifies maintenance when UI changes

✔ Test Runner Strategy

Cucumber + TestNG integration

Tag-based execution

Parallel execution support

Environment-based test selection


✔ Configuration Management

Environment-specific properties

Browser, URL, credentials configurable

No hard-coded values

🔍 Test Coverage
🖥 UI Automation (BDD)

Admin login & role validation

Product creation and management

Customer registration & login

Cart & checkout workflows

Order verification (Admin & Customer)

Negative & edge-case scenarios

🔗 API Automation (BDD)

Product and user CRUD operations

Request/response validation

Schema validation

Authorization handling

Data-driven scenarios

Negative API cases

🏷 Tags Strategy
Tag	Purpose
@ui	UI test scenarios
@api	API test scenarios
@smoke	Smoke suite
@regression	Regression suite
@admin	Admin flows
@checkout	Checkout scenarios


▶ How to Run Tests
📌 Prerequisites

Java 17+

Maven

Chrome browser

Git


🔄 CI/CD Integration

The framework integrates with GitHub Actions to:

Execute tests on pull requests

Run tagged suites

Generate and archive reports

Fail builds on test failures

📌 Designed for fast feedback & shift-left testing.


👤 Author

Amritpal Singh
Senior QA Automation Engineer
16+ years of experience in Automation, BDD, and Quality Engineering

📌 GitHub: https://github.com/amritpalsohi

