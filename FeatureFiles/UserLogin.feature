@all
Feature: User Login

@login  @validcredentials  @smoke
 Scenario Outline: Login with valid credentials
   Given User navigate to login page
   When User enters valid email address <email> into email field
   And User enters valid password <password> into password field
   And User clicks on login button
   Then Login successful page should be visible
 Examples:
 
   |email               |password     |
   |LastLast12@gmail.com|Test@123|
  |registeracc@gmail.com|Register@123|
   |Loginreg@gmail.com   |Login@123    |
   
  @login  @invalidcredentials  @smoke  @regression 
   Scenario: Login with Invalid credentials
   Given User navigate to login page
   When User enters Invalid email and Invalid password "123456"
   And User clicks on login button
   Then User should get proper warning message about credentials mismatch
   
   @login  @invalidemailandvalidpassword @regression
  Scenario: Login with Invalid email and valid password
   Given User navigate to login page
   When User enters Invalid email and valid password "12345"
   And User clicks on login button
   Then User should get proper warning message about credentials mismatch
   
    @login  @withoutcredentials @regression @ignore
   Scenario: Login without providing any credentials
    Given User navigate to login page
   When User enters don't enter email addressS into email field
    When User enters don't enter password address into password field
   And User clicks on login button
   Then User should get proper warning message about credentials mismatch
   