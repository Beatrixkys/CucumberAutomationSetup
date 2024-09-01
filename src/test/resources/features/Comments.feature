Feature: Comments API

@Comment1 @Feature-Comments
  Scenario: Get comment by ID
    Given the API endpoint is "/comments/3"
    When I send a GET request
    Then the response status code should be 200
    And the response should contain a comment with ID 3 and email "Nikita@garfield.biz"

@Comment2 @Feature-Comments
  Scenario: Create a new comment
    Given the API endpoint is "/comments"
    And the request body is:
      """
      {
        "postId": 1,
        "name": "Melissa",
        "email": "abc@gmail.com",
        "body": "This is a test comment"
      }
      """
    When I send a POST request
    Then the response status code should be 201
    And the response should return a comment ID of 501