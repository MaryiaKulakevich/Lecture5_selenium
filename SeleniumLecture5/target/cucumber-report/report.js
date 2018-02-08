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
  "duration": 133721486,
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
  "duration": 1400620032,
  "status": "passed"
});
formatter.match({
  "location": "MailLoginSteps.userEntersCredentialsAndClicksEnterButton()"
});
formatter.result({
  "duration": 1791023111,
  "status": "passed"
});
formatter.match({
  "location": "MailLoginSteps.userIsLoggedInToHisAccount()"
});
formatter.result({
  "duration": 5767358918,
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
    },
    {
      "cells": [
        "lecture11 selenium"
      ],
      "line": 23,
      "id": "mail-basic-tests;create-a-mail;;4"
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
  "duration": 291839,
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
  "duration": 1440609758,
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
  "duration": 2844859866,
  "status": "passed"
});
formatter.match({
  "location": "CreateMailSteps.theMailIsSavedInDraftsWith()"
});
formatter.result({
  "duration": 464130164,
  "status": "passed"
});
formatter.match({
  "location": "CreateMailSteps.addresseeIsCorrect()"
});
formatter.result({
  "duration": 361951265,
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
  "duration": 246186,
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
  "duration": 1267852571,
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
  "duration": 2483002468,
  "status": "passed"
});
formatter.match({
  "location": "CreateMailSteps.theMailIsSavedInDraftsWith()"
});
formatter.result({
  "duration": 612140704,
  "status": "passed"
});
formatter.match({
  "location": "CreateMailSteps.addresseeIsCorrect()"
});
formatter.result({
  "duration": 321739672,
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
  "duration": 275200,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "Create a mail",
  "description": "",
  "id": "mail-basic-tests;create-a-mail;;4",
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
  "name": "user fills in addressee, \"lecture11 selenium\", body and keys CTRL_S in",
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
  "duration": 5631452048,
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for element to be clickable: [[ChromeDriver: chrome on XP (920af3e1f5b5be5c8dd9762903ade813)] -\u003e xpath: //div[@class\u003d\u0027b-sticky\u0027]//a[@data-name\u003d\u0027compose\u0027]] (tried for 5 second(s) with 500 MILLISECONDS interval)\nBuild info: version: \u00273.8.1\u0027, revision: \u00276e95a6684b\u0027, time: \u00272017-12-01T18:33:54.468Z\u0027\nSystem info: host: \u0027MASHA-HP\u0027, ip: \u0027192.168.100.6\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_131\u0027\nDriver info: by.epam.atm.patterns.decorator.driver_decorator.WebDriverDecorator\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:82)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:231)\r\n\tat by.epam.atm.patterns.staticfactory.CustomWaiter.waitUntilClickable(CustomWaiter.java:28)\r\n\tat by.epam.atm.lecture10.pages.LoggedInPage.createMail(LoggedInPage.java:27)\r\n\tat by.epam.atm.lecture10.steps.CreateMailSteps.userCreatesANewMail(CreateMailSteps.java:27)\r\n\tat ✽.Given user creates a new mail(src/test/resources/features_cucumber/mail_tests.feature:14)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "lecture11 selenium",
      "offset": 26
    }
  ],
  "location": "CreateMailSteps.userFillsInAddresseeBodyAndKeysCTRL_SIn(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CreateMailSteps.theMailIsSavedInDraftsWith()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "CreateMailSteps.addresseeIsCorrect()"
});
formatter.result({
  "status": "skipped"
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
  "duration": 361387,
  "status": "passed"
});
formatter.scenario({
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
  "duration": 548070359,
  "status": "passed"
});
formatter.match({
  "location": "DraftMailSteps.theMessageBodyIsCorrect()"
});
formatter.result({
  "duration": 954573265,
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
  "duration": 355839,
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
  "duration": 1540929672,
  "status": "passed"
});
formatter.match({
  "location": "DraftMailSteps.theMailDisappearsFromDrafts()"
});
formatter.result({
  "duration": 10478049298,
  "status": "passed"
});
formatter.match({
  "location": "DraftMailSteps.appearsInSent()"
});
formatter.result({
  "duration": 1221189785,
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
  "duration": 338773,
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
  "duration": 333226,
  "status": "passed"
});
formatter.match({
  "location": "RemoveFromSentSteps.userDragsAndDropsTheMailToTheBin()"
});
formatter.result({
  "duration": 2093137841,
  "status": "passed"
});
formatter.match({
  "location": "RemoveFromSentSteps.theMaleIsRemovedFromSent()"
});
formatter.result({
  "duration": 10531711973,
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
  "duration": 285013,
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
  "name": "user clicks select all checkbox and drags and drops 2 mails to the bin",
  "keyword": "When "
});
formatter.step({
  "line": 46,
  "name": "2 mails removed",
  "keyword": "Then "
});
formatter.match({
  "location": "RemoveFromDraftsSteps.userReturnsToDraftsFolder()"
});
formatter.result({
  "duration": 469294106,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 52
    }
  ],
  "location": "RemoveFromDraftsSteps.removeToBin(int)"
});
formatter.result({
  "duration": 2382453434,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 0
    }
  ],
  "location": "RemoveFromDraftsSteps.mailIsRemoved(int)"
});
formatter.result({
  "duration": 10431757712,
  "status": "passed"
});
});