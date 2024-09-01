package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.SauceLoginPage;

public class SauceLoginSteps {

     SauceLoginPage sauceLoginPage = new SauceLoginPage();

    @Given("I login with username {string} and password {string}")
    public void onVysorPage1(String username, String password){
        sauceLoginPage.inputUsername(username);
        sauceLoginPage.inputPassword(password);   
        sauceLoginPage.clickLogin();
    }

    @Then ("I should see error message {string}")
    public void seeErrorMessage(String expected){
        sauceLoginPage.assertErrorMessage(expected);
    }
    
}
