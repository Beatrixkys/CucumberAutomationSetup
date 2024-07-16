Feature: Vysor

  @Vysor1
  Scenario: To Validate Swipe Page on Vysor
    Given I am on Vysor Page 1
    And I swipe right
    Then Vysor Page 2 is shown
    And I swipe right
    Then Vysor Page 3 is shown
    And I swipe right
    Then Vysor Page 4 is shown

  @Vysor2
  Scenario: To Validate Next Click on Vysor
    Given I am on Vysor Page 1
    And I click on Next Button
    Then Vysor Page 4 is shown