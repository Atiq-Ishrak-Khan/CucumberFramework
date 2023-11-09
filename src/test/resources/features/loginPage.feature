Feature: Login Functionality for OpenCart website


  Background:
    Given User is on the OpenCart login page


    Scenario: Login Successful with valid credentials
      Given User entered a valid username and password
      When User click on the login button
      Then User should be logged in Successfully


    Scenario Outline: Login Unsuccessful with invalid or empty credentials
        Given User entered invalid "<username>" and "<password>"
        When User click on the login button
        Then User should see an error message saying "<error_message>"

        Examples:
          | username       | password | error_message                                         |
          | abcd@gmail.com | invpass  | Warning: No match for E-mail Address and/or Password. |
          | technology     | 12345    | Warning: No match for E-mail Address and/or Password. |
          | validemail.com | ABCD     | Warning: No match for E-mail Address and/or Password. |


    Scenario: Navigate to the forgotten password page
      When User click on the "Forgotten Password" link
      Then User should be redirected to the password reset page
