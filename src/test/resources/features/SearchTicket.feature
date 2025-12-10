Feature: Search for train ticket

  Scenario: User successfully search for a ticket
    Given user is on the ADY homepage
    When user selects from city "Bakı DYV"
    And user selects to city "Gəncə"
    And user selects travel date "20.12.2025"
    And user clicks search button
    Then search results should be displayed
