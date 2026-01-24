@apitest
Feature: Create User API

  Scenario Outline: Validate create user API
    Given The API is available
    When User I create the user with body details of id <id> email "<email>" first_name "<first_name>" last_name "<last_name>" avatar "<avatar>"
    Then Response code should be 201

    Examples:
      | id | email                  | first_name | last_name | avatar                                |
      | 1  | test001@mailinator.com | First_Test | Last_Test | https://reqres.in/img/faces/4-image.jpg |