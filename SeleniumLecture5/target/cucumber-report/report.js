$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features_cucumber/mail_tests.feature");
formatter.feature({
  "line": 1,
  "name": "Mail basic tests",
  "description": "",
  "id": "mail-basic-tests",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Mail login",
  "description": "",
  "id": "mail-basic-tests;mail-login",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@smokeTest"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "user navigates to mail home page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "user enters credentials and clicks enter button",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "user is logged in to his account",
  "keyword": "Then "
});
formatter.match({
  "location": "MailLoginSteps.userNavigatesToMailHomePage()"
});
formatter.result({
  "duration": 1402260217,
  "status": "passed"
});
formatter.match({
  "location": "MailLoginSteps.userEntersCredentialsAndClicksEnterButton()"
});
formatter.result({
  "duration": 323940070,
  "status": "passed"
});
formatter.match({
  "location": "MailLoginSteps.userIsLoggedInToHisAccount()"
});
formatter.result({
  "duration": 3872757090,
  "status": "passed"
});
});