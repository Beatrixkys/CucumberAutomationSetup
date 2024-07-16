package steps;

import cucumber.api.java.en.Given;
import pages.VysorWebPage;
import utils.MobileHandlers;

public class VysorWebSteps {
    @Given("I am on Vysor Web")
    public void onVysorWeb(){
        VysorWebPage vysorWebPage = new VysorWebPage();
        vysorWebPage.validateFirstLoad();
        vysorWebPage.checkButtons();
        //Check buttons
    }

}
