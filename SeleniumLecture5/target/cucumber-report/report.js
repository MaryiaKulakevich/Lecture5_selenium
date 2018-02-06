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
  "duration": 104390372,
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
  "duration": 1216559981,
  "status": "passed"
});
formatter.match({
  "location": "MailLoginSteps.userEntersCredentialsAndClicksEnterButton()"
});
formatter.result({
  "duration": 1658427968,
  "status": "passed"
});
formatter.match({
  "location": "MailLoginSteps.userIsLoggedInToHisAccount()"
});
formatter.result({
  "duration": 25083773357,
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
  "name": "the mail is saved in Drafts with \"\u003csubject\u003e\"",
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
  "duration": 315362,
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
  "name": "the mail is saved in Drafts with \"lecture9 selenium\"",
  "matchedColumns": [
    0
  ],
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
  "duration": 866008533,
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
  "duration": 3350184148,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "lecture9 selenium",
      "offset": 34
    }
  ],
  "location": "CreateMailSteps.theMailIsSavedInDraftsWith(String)"
});
formatter.result({
  "duration": 474377316,
  "status": "passed"
});
formatter.match({
  "location": "CreateMailSteps.addresseeIsCorrect()"
});
formatter.result({
  "duration": 351535476,
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
  "duration": 253782,
  "status": "passed"
});
formatter.scenario({
  "comments": [
    {
      "line": 23,
      "value": "#@smokeTest"
    },
    {
      "line": 24,
      "value": "#  Scenario: Check body message"
    },
    {
      "line": 25,
      "value": "#  When user opens the saved mail"
    },
    {
      "line": 26,
      "value": "#  Then the message body is correct"
    }
  ],
  "line": 29,
  "name": "Send mail",
  "description": "",
  "id": "mail-basic-tests;send-mail",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 28,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 30,
  "name": "user opens the saved mail",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "clicks send button",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "the mail disappears from Drafts",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "appears in Sent",
  "keyword": "And "
});
formatter.match({
  "location": "DraftMailSteps.userOpensTheSavedMail()"
});
formatter.result({
  "duration": 629113310,
  "status": "passed"
});
formatter.match({
  "location": "DraftMailSteps.clicksSendButton()"
});
formatter.result({
  "duration": 2130396217,
  "status": "passed"
});
formatter.match({
  "location": "DraftMailSteps.theMailDisappearsFromDrafts()"
});
formatter.result({
  "duration": 20796814285,
  "status": "passed"
});
formatter.match({
  "location": "DraftMailSteps.appearsInSent()"
});
formatter.result({
  "duration": 1510884027,
  "status": "passed"
});
});