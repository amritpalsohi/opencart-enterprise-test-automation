@Login
  Feature: Login to Open Cart

    Background:
      Given Navigate to login page

      Scenario Outline: Validate that user is able to login to open cart
        Given User is landed on login page
        When User enters username and password for <Feature>
        Then User is logged in the application

        Examples:
        |Feature|
        |Login  |
