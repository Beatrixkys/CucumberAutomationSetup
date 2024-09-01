Feature: Users API

@Feature-Users
  Scenario: Get user by ID
    Given the API endpoint is "/users/6"
    When I send a GET request
    Then the response status code should be 200
    And the response should contain a user with street "Norberto Crossing" and city "South Christy"