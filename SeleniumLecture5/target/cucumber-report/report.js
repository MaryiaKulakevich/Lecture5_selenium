$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features_cucumber/mail_tests.feature");
formatter.feature({
  "line": 1,
  "name": "Mail basic tests",
  "description": "",
  "id": "mail-basic-tests",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to Drafts folder",
  "keyword": "Given "
});
formatter.match({
  "location": "DraftMailSteps.userNavigatesToDraftsFolder()"
});
formatter.result({
  "duration": 161956913,
  "status": "passed"
});
formatter.scenario({
  "line": 7,
  "name": "Mail login",
  "description": "",
  "id": "mail-basic-tests;mail-login",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "user navigates to mail home page",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "user enters credentials and clicks enter button",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "user is logged in to his account",
  "keyword": "Then "
});
formatter.match({
  "location": "MailLoginSteps.userNavigatesToMailHomePage()"
});
formatter.result({
  "duration": 1478132722,
  "status": "passed"
});
formatter.match({
  "location": "MailLoginSteps.userEntersCredentialsAndClicksEnterButton()"
});
formatter.result({
  "duration": 1933711445,
  "status": "passed"
});
formatter.match({
  "location": "MailLoginSteps.userIsLoggedInToHisAccount()"
});
formatter.result({
  "duration": 5073008974,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 13,
  "name": "Create a mail",
  "description": "",
  "id": "mail-basic-tests;create-a-mail",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 12,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "user creates a new mail",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "user fills in addressee, \"\u003csubject\u003e\", body and keys CTRL_S in",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "the mail is saved in Drafts",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "addressee is correct",
  "keyword": "And "
});
formatter.examples({
  "line": 19,
  "name": "",
  "description": "",
  "id": "mail-basic-tests;create-a-mail;",
  "rows": [
    {
      "cells": [
        "subject"
      ],
      "line": 20,
      "id": "mail-basic-tests;create-a-mail;;1"
    },
    {
      "cells": [
        "lecture9 selenium"
      ],
      "line": 21,
      "id": "mail-basic-tests;create-a-mail;;2"
    },
    {
      "cells": [
        "lecture10 selenium"
      ],
      "line": 22,
      "id": "mail-basic-tests;create-a-mail;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to Drafts folder",
  "keyword": "Given "
});
formatter.match({
  "location": "DraftMailSteps.userNavigatesToDraftsFolder()"
});
formatter.result({
  "duration": 451839,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "Create a mail",
  "description": "",
  "id": "mail-basic-tests;create-a-mail;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 12,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "user creates a new mail",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "user fills in addressee, \"lecture9 selenium\", body and keys CTRL_S in",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "the mail is saved in Drafts",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "addressee is correct",
  "keyword": "And "
});
formatter.match({
  "location": "CreateMailSteps.userCreatesANewMail()"
});
formatter.result({
  "duration": 872789496,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "lecture9 selenium",
      "offset": 26
    }
  ],
  "location": "CreateMailSteps.userFillsInAddresseeBodyAndKeysCTRL_SIn(String)"
});
formatter.result({
  "duration": 2925109429,
  "status": "passed"
});
formatter.match({
  "location": "CreateMailSteps.theMailIsSavedInDrafts()"
});
formatter.result({
  "duration": 538688164,
  "status": "passed"
});
formatter.match({
  "location": "CreateMailSteps.addresseeIsCorrect()"
});
formatter.result({
  "duration": 364051587,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to Drafts folder",
  "keyword": "Given "
});
formatter.match({
  "location": "DraftMailSteps.userNavigatesToDraftsFolder()"
});
formatter.result({
  "duration": 266239,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "Create a mail",
  "description": "",
  "id": "mail-basic-tests;create-a-mail;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 12,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "user creates a new mail",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "user fills in addressee, \"lecture10 selenium\", body and keys CTRL_S in",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "the mail is saved in Drafts",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "addressee is correct",
  "keyword": "And "
});
formatter.match({
  "location": "CreateMailSteps.userCreatesANewMail()"
});
formatter.result({
  "duration": 568669565,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "lecture10 selenium",
      "offset": 26
    }
  ],
  "location": "CreateMailSteps.userFillsInAddresseeBodyAndKeysCTRL_SIn(String)"
});
formatter.result({
  "duration": 2536588114,
  "status": "passed"
});
formatter.match({
  "location": "CreateMailSteps.theMailIsSavedInDrafts()"
});
formatter.result({
  "duration": 733671167,
  "status": "passed"
});
formatter.match({
  "location": "CreateMailSteps.addresseeIsCorrect()"
});
formatter.result({
  "duration": 327760221,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to Drafts folder",
  "keyword": "Given "
});
formatter.match({
  "location": "DraftMailSteps.userNavigatesToDraftsFolder()"
});
formatter.result({
  "duration": 326826,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 23,
      "value": "#| lecture11 selenium  |"
    }
  ],
  "line": 26,
  "name": "Check body message",
  "description": "",
  "id": "mail-basic-tests;check-body-message",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 25,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 27,
  "name": "user opens the saved mail",
  "keyword": "When "
});
formatter.step({
  "line": 28,
  "name": "the message body is correct",
  "keyword": "Then "
});
formatter.match({
  "location": "DraftMailSteps.userOpensTheSavedMail()"
});
formatter.result({
  "duration": 566369835,
  "status": "passed"
});
formatter.match({
  "location": "DraftMailSteps.theMessageBodyIsCorrect()"
});
formatter.result({
  "duration": 1002596263,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to Drafts folder",
  "keyword": "Given "
});
formatter.match({
  "location": "DraftMailSteps.userNavigatesToDraftsFolder()"
});
formatter.result({
  "duration": 425386,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "Send mail",
  "description": "",
  "id": "mail-basic-tests;send-mail",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 30,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 32,
  "name": "user clicks send button",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "the mail disappears from Drafts",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "appears in Sent",
  "keyword": "And "
});
formatter.match({
  "location": "DraftMailSteps.clickSendButton()"
});
formatter.result({
  "duration": 1610283165,
  "status": "passed"
});
formatter.match({
  "location": "DraftMailSteps.theMailDisappearsFromDrafts()"
});
formatter.result({
  "duration": 10428400945,
  "status": "passed"
});
formatter.match({
  "location": "DraftMailSteps.appearsInSent()"
});
formatter.result({
  "duration": 1254688954,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to Drafts folder",
  "keyword": "Given "
});
formatter.match({
  "location": "DraftMailSteps.userNavigatesToDraftsFolder()"
});
formatter.result({
  "duration": 654079,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "Remove the mail from Sent",
  "description": "",
  "id": "mail-basic-tests;remove-the-mail-from-sent",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 36,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 38,
  "name": "user navigates to Sent folder",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "user drags and drops the mail to the bin",
  "keyword": "When "
});
formatter.step({
  "line": 40,
  "name": "the male is removed from Sent",
  "keyword": "Then "
});
formatter.match({
  "location": "RemoveFromSentSteps.userNavigatesToSentFolder()"
});
formatter.result({
  "duration": 414293,
  "status": "passed"
});
formatter.match({
  "location": "RemoveFromSentSteps.userDragsAndDropsTheMailToTheBin()"
});
formatter.result({
  "duration": 2009969481,
  "status": "passed"
});
formatter.match({
  "location": "RemoveFromSentSteps.theMaleIsRemovedFromSent()"
});
formatter.result({
  "duration": 10425109216,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user navigates to Drafts folder",
  "keyword": "Given "
});
formatter.match({
  "location": "DraftMailSteps.userNavigatesToDraftsFolder()"
});
formatter.result({
  "duration": 666452,
  "status": "passed"
});
formatter.scenario({
  "line": 43,
  "name": "Remove mails from Drafts",
  "description": "",
  "id": "mail-basic-tests;remove-mails-from-drafts",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 42,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 44,
  "name": "user returns to Drafts folder",
  "keyword": "Given "
});
formatter.step({
  "line": 45,
  "name": "user clicks select all checkbox and drags and drops 1 mail to the bin",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "1 mail removed",
  "keyword": "Then "
});
formatter.match({
  "location": "RemoveFromDraftsSteps.userReturnsToDraftsFolder()"
});
formatter.result({
  "duration": 518618643,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 52
    }
  ],
  "location": "RemoveFromDraftsSteps.removeToBin(int)"
});
formatter.result({
  "duration": 3069240658,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 0
    }
  ],
  "location": "RemoveFromDraftsSteps.mailIsRemoved(int)"
});
formatter.result({
  "duration": 10447594094,
  "status": "passed"
});
});