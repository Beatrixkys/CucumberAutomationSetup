package steps;

import cucumber.api.java.en.Given;
import pages.VysorWebPage;

public class VysorWebSteps {

    VysorWebPage vysorWebPage = new VysorWebPage();
    @Given("I am on Vysor Web")
    public void onVysorWeb(){
        vysorWebPage.validateFirstLoad();
        vysorWebPage.checkButtons();
    }

}
