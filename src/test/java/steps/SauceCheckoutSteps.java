package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.SauceCheckoutPage;

public class SauceCheckoutSteps {
    
    SauceCheckoutPage sauceCheckoutPage = new SauceCheckoutPage(); 

    @Then("I should be on Checkout Page {string}")
    public void shouldBeOnCheckoutPage(String pageName) {
        sauceCheckoutPage.verifyTitle(pageName);
        if (pageName.equals("Your Cart") || pageName.equals("Checkout: Overview")){
            sauceCheckoutPage.verifyQtyDescLabel();
        }
   }

    @When("I click on Checkout")
    public void clickOnCheckout() {
        sauceCheckoutPage.clickCheckoutButton();
        // Implementation for clicking the Checkout button
    }

    @When("I fill in Checkout details")
    public void fillInCheckoutDetails() {
        sauceCheckoutPage.inputFirstName("Test");
        sauceCheckoutPage.inputLastName("Name");
        sauceCheckoutPage.inputZipCode("zipCode");
           }

    @And("I click Continue")
    public void clickContinue() {
        sauceCheckoutPage.clickContinue();
    }

    @When("I click Finish")
    public void clickFinish() {
        sauceCheckoutPage.clickFinish();
    }

    @Then("I should see Completed Page")
    public void shouldSeeCompletedPage() {
        sauceCheckoutPage.verifyComplete();
    }

}
