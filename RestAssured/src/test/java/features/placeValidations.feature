Feature: Add place details and validating for Place API.

  Scenario Outline: Add a place to the map by using add API.
    Given add place details payload with "<Name>" <Accuracy> "<Phone_number>" "<Website>" "<Language>"

    When user submit the "addAddress" "POST" request
    Then place shall be added successfully
   # And "status" code as "OK"
    #And "scop" code as "APP"
  Examples:
    |Name   |Accuracy|Phone_number     |Website           |Language|
    |abcd   |12      |+044-9129393939  |https.cbc.com     |English |
    |abcdq11|1222    |+044-9129393939  |https.cbc2.com    |Telugu|

