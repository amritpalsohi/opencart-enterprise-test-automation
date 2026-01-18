@CreateUserApi
Feature: Create User API

  Scenario Outline: Validate create user API
    Given The API is available
    When User I create the user with body details
    Then Response code should be 201

    Examples:
      |Feature|
      |Login  |