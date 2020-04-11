$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/HP/Documents/Framework/FreeCRMTestAutomation/src/test/java/features/DealsPage.feature");
formatter.feature({
  "line": 1,
  "name": "Deals Page feature",
  "description": "\r\nDescription: This feature validates deals page",
  "id": "deals-page-feature",
  "keyword": "Feature"
});
formatter.before({
  "duration": 29820441800,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Deals page Scenario",
  "description": "",
  "id": "deals-page-feature;deals-page-scenario",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "User moves to new deals page",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User enters deals details",
  "rows": [
    {
      "cells": [
        "Title",
        "Description"
      ],
      "line": 8
    },
    {
      "cells": [
        "Mrs",
        "Free CRM Description1"
      ],
      "line": 9
    },
    {
      "cells": [
        "Mrs",
        "Free CRM Description2"
      ],
      "line": 10
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "DealsTestCase.user_moves_to_new_deals_page()"
});
formatter.result({
  "duration": 16295556300,
  "status": "passed"
});
formatter.match({
  "location": "DealsTestCase.user_enters_deals_details(DataTable)"
});
formatter.result({
  "duration": 18444586300,
  "status": "passed"
});
formatter.after({
  "duration": 2687319400,
  "status": "passed"
});
});