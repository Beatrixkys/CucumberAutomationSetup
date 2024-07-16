package steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.VysorStartPage;
import utils.MobileHandlers;

import static org.junit.Assert.assertEquals;

public class VysorStartSteps {
    VysorStartPage vysorStartPage = new VysorStartPage();

    @Given("I am on Vysor Page 1")
    public void onVysorPage1(){
        vysorStartPage.checkPermission();
        vysorStartPage.validateFirstPageView();
    }
    @Then("Vysor Page {int} is shown")
    public void pageIsShown(int pageNo){
        switch (pageNo){
            case 1: vysorStartPage.validateFirstPageView();
                break;
            case 2: vysorStartPage.validateSecondPageView();
                break;
            case 3: vysorStartPage.validateThirdPageView();
                break;
            case 4: vysorStartPage.validateFourthPageView();
                break;
        }
    }
    @And("I swipe right")
    public void iAddAndAdd(){
        vysorStartPage.nextPageOnVysor();
    }
    @And("I click on Next Button")
    public void clickNext(){
        vysorStartPage.clickNextButton();
    }
}
