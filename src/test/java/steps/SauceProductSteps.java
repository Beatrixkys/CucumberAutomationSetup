package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import pages.SauceProductPage;

public class SauceProductSteps {
    SauceProductPage sauceProductPage = new SauceProductPage();
    @Then ("I should be on Products page")
    public void onProductsPage(){
        sauceProductPage.assertProductTitle();
    }
    @And("I select first Product to checkout")
    public void selectFirstProductToCheckout() {
        sauceProductPage.selectFirstProduct();
    }
    @And("I click on Shopping Cart")
    public void clickOnShoppingCart() {
        sauceProductPage.clickShoppingCart();
    }
}
