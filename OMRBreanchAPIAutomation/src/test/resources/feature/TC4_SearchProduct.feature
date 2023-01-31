Feature: Search Product module API automation

  Scenario Outline: Verify Search Product for the application through api
    Given User add header and bearer authentication for accessing search product endpoint
    When User add request body for search product "<product>"
    And User send a "POST" request for searchProduct endpoint
    Then User verify the status code is 200
    And User verify the Search Product response message matches "OK"

    Examples: 
      | product |
      | nuts    |
