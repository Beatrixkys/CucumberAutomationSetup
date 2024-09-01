Feature: Login

@Login1 @Feature:Login
Scenario: To validate login
    Given I login with username "standard_user" and password "secret_sauce"
    Then I should be on Products page

@Login2 @Feature:Login
Scenario: To validate login with locked out user
    Given I login with username "locked_out_user" and password "secret_sauce"
    Then I should see error message "Epic sadface: Sorry, this user has been locked out."

@Login3 @Feature:Login
Scenario: To validate incorrect password
    Given I login with username "standard_user" and password "secretsauce"
    Then I should see error message "Epic sadface: Username and password do not match any user in this service"