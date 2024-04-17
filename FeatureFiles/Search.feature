@all
Feature: Search functionality

@search @validproduct @smoke @sanity
Scenario: User searches for a valid product
Given User opens the Application
When User enters valid product "HP" into Search box field
And User clicks on search button
Then User should get valid product displayed in search results

@search @invalidproduct @regression
Scenario: User searches for an invalid product
Given User opens the Application
When User enters invalid product "Honda" into Search box field
And User clicks on search button
Then User should get a message about no product matching

@search @nonproduct  @sanity
Scenario: User searches without any product
Given User opens the Application
When User don't enter any product name into search box field
And User clicks on search button
Then User should get a message about no product matching
