Feature: Mail basic tests

@smokeTest
Scenario: Mail login
Given user navigates to mail home page
When  user enters credentials and clicks enter button
Then  user is logged in to his account