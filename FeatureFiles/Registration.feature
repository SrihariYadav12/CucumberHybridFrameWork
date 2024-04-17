@all
Feature: Registration functionality

@register  @mandatoryfields @sanity
Scenario: User Register with mandatory details

 Given User navigates to the register page
 When Enter below all mandatory details
 |Firstname|Testlogin|
 |Lastname|Lastreg|
 |telephone|765456788|
 |Password|Regtest@123|
 And User selects privacy policy
 And User click on continue button
 Then User account should create successfully
 
 @register  @duplicateemail  @regression
 Scenario: User creates a duplicate account

 Given User navigates to the register page
 When Enter below all mandatory details
 |Firstname|Testlogin|
 |Lastname|Lastreg|
 |Email|testreglast@gmail.com|
 |telephone|765456788|
 |Password|Regtest@123|
 And User selects privacy policy
 And User click on continue button
 Then User should get prope warning about duplicate email

 