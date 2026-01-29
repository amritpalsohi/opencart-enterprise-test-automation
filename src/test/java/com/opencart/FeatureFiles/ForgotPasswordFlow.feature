@ForgotPassword @SmokeTest
  Feature: Forgot Password Flow

      Scenario Outline: Validate that user is able to reset their passwords
        Given User is landed on Unauth page
        When User clicks on Forgot Password Link
        And User enters username and click reset password for <Feature>
        Then Password Notification has been sent to email

        Examples:
        |Feature|
        |Forgot Password|
