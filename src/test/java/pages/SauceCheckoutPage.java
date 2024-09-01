package pages;

import static org.junit.Assert.assertEquals;

import utils.WebHandlers;

public class SauceCheckoutPage {

    public void verifyTitle(String expected){
        WebHandlers.getText("SauceCheckout.checkoutTitle");
    }
    
    public void verifyQtyDescLabel(){
        WebHandlers.checkElementDisplayed("SauceCheckout.qtyLabel");
        WebHandlers.checkElementDisplayed("SauceCheckout.descriptionLabel");
    }
    public void clickCheckoutButton() {
        WebHandlers.click("SauceCheckout.checkoutButton");
    }

    public void clickContinue() {
        WebHandlers.click("SauceCheckout.continueButton");
    }

    public void clickFinish() {
        if(!WebHandlers.booleanElementDisplayed("SauceCheckout.finishButton")){
            WebHandlers.scrollDown();
        }
        WebHandlers.click("SauceCheckout.finishButton");
    }

    public void inputFirstName(String firstName) {
        WebHandlers.enterText("SauceCheckout.firstNameInput", firstName);
    }

    public void inputLastName(String lastName) {
        WebHandlers.enterText("SauceCheckout.lastNameInput", lastName);
    }

    public void inputZipCode(String zipCode) {
        WebHandlers.enterText("SauceCheckout.zipCodeInput", zipCode);
    }

    public void verifyComplete() {
        String headerExpected = "Thank you for your order!";
        String subheaderExpected = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
        String headerActual = WebHandlers.getText("SauceCheckout.checkoutCompleteHeader");
        String subheaderActual = WebHandlers.getText("SauceCheckout.checkoutCompleteText");
        assertEquals(headerExpected,headerActual);
        assertEquals(subheaderExpected,subheaderActual);
        WebHandlers.checkElementDisplayed("SauceCheckout.backHomeButton");
    }

    
}
