package steps;

import cucumber.api.java.en.Given;
import utils.MobileHandlers;

public class VysorWebSteps {
    @Given("I am on Vysor Web")
    public void onVysorWeb(){
        MobileHandlers.checkElementDisplayed("VysorWebPage.headerTitle");
        MobileHandlers.checkElementDisplayed("VysorWebPage.phoneImage");
    }

}
