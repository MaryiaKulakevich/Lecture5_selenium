Feature: Mail basic tests

Background:
  Given user navigates to Drafts folder

@smokeTest
Scenario: Mail login
Given user navigates to mail home page
When  user enters credentials and clicks enter button
Then  user is logged in to his account

@smokeTest
Scenario Outline: Create a mail
Given user creates a new mail
When user fills in addressee, "<subject>", body and keys CTRL_S in
Then the mail is saved in Drafts
And addressee is correct

Examples:
| subject     |
| lecture9 selenium   |

#@smokeTest
#  Scenario: Check body message
#  When user opens the saved mail
#  Then the message body is correct
#
# @smokeTest
# Scenario: Send mail
# When clicks send button
# Then the mail disappears from Drafts
# And appears in Sent

