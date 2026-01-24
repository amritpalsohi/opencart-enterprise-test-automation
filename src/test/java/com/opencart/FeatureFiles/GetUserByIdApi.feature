@getapitest
Feature: Get User By Id

  Scenario Outline: Validate get user by Id API
    Given The Get API by Id is available
    When User passes the id <id> in get request parameter
    Then Response code should be 200

    Examples:
      |id|
      |2|