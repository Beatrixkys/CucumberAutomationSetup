package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Then;
import pages.UsersAPI;

public class UserSteps {
    
    UsersAPI usersAPI = new UsersAPI();
    

    @Then ("the response should contain a user with street {string} and city {string}")
    public void verifyUserAddress(String expectedStreet, String expectedCity) {
        assertTrue(usersAPI.responseContainsUserWithStreetAndCity(expectedStreet, expectedCity));
    }
}
