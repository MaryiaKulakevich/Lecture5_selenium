Feature: Mail basic tests

@smokeTest
Scenario: Mail login
Given user navigates to mail home page
When  user enters credentials and clicks enter button
Then  user is logged in to his account

@smokeTest
Scenario: Create a mail
Given user creates a new mail
When user fills in addressee and subject
And  keys TAB in, types mail body and keys CTRL+S in
Then the mail is saved in Drafts
