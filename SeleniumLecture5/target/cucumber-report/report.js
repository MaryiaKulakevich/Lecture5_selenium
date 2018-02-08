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
  "duration": 10549629683,
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
  "duration": 1344616176,
  "status": "passed"
});
formatter.match({
  "location": "MailLoginSteps.userEntersCredentialsAndClicksEnterButton()"
});
formatter.result({
  "duration": 1811571914,
  "status": "passed"
});
formatter.match({
  "location": "MailLoginSteps.userIsLoggedInToHisAccount()"
});
formatter.result({
  "duration": 4808389061,
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
  "duration": 10371508083,
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
  "duration": 1090429235,
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
  "duration": 3609311136,
  "status": "passed"
});
formatter.match({
  "location": "CreateMailSteps.theMailIsSavedInDraftsWith()"
});
formatter.result({
  "duration": 72776,
  "status": "passed"
});
formatter.match({
  "location": "CreateMailSteps.addresseeIsCorrect()"
});
formatter.result({
  "duration": 395799654,
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
  "duration": 335524486,
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
  "duration": 579061590,
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
  "duration": 3421302600,
  "status": "passed"
});
formatter.match({
  "location": "CreateMailSteps.theMailIsSavedInDraftsWith()"
});
formatter.result({
  "duration": 41364,
  "status": "passed"
});
formatter.match({
  "location": "CreateMailSteps.addresseeIsCorrect()"
});
formatter.result({
  "duration": 356058773,
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
  "duration": 359713114,
  "status": "passed"
});
formatter.scenario({
  "line": 25,
  "name": "Check body message",
  "description": "",
  "id": "mail-basic-tests;check-body-message",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 24,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 26,
  "name": "user opens the saved mail",
  "keyword": "When "
});
formatter.step({
  "line": 27,
  "name": "the message body is correct",
  "keyword": "Then "
});
formatter.match({
  "location": "DraftMailSteps.userOpensTheSavedMail()"
});
formatter.result({
  "duration": 244784245,
  "status": "passed"
});
formatter.match({
  "location": "DraftMailSteps.theMessageBodyIsCorrect()"
});
formatter.result({
  "duration": 967638711,
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
  "duration": 10385144528,
  "status": "passed"
});
formatter.scenario({
  "line": 30,
  "name": "Send mail",
  "description": "",
  "id": "mail-basic-tests;send-mail",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 29,
      "name": "@smokeTest"
    }
  ]
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
  "location": "DraftMailSteps.clicksSendButton()"
});
formatter.result({
  "duration": 12047647008,
  "status": "passed"
});
formatter.match({
  "location": "DraftMailSteps.theMailDisappearsFromDrafts()"
});
formatter.result({
  "duration": 3831615,
  "status": "passed"
});
formatter.match({
  "location": "DraftMailSteps.appearsInSent()"
});
formatter.result({
  "duration": 1450538261,
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
  "duration": 407462134,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "Remove the mail from Sent",
  "description": "",
  "id": "mail-basic-tests;remove-the-mail-from-sent",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 35,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 37,
  "name": "user navigates to Sent folder",
  "keyword": "Given "
});
formatter.step({
  "line": 38,
  "name": "user drags and drops the mail to the bin",
  "keyword": "When "
});
formatter.step({
  "line": 39,
  "name": "the male is removed from Sent",
  "keyword": "Then "
});
formatter.match({
  "location": "RemoveMailSteps.userNavigatesToSentFolder()"
});
formatter.result({
  "duration": 237921,
  "status": "passed"
});
formatter.match({
  "location": "RemoveMailSteps.userDragsAndDropsTheMailToTheBin()"
});
formatter.result({
  "duration": 2019003195,
  "status": "passed"
});
formatter.match({
  "location": "RemoveMailSteps.theMaleIsRemovedFromSent()"
});
formatter.result({
  "duration": 10444849619,
  "status": "passed"
});
});