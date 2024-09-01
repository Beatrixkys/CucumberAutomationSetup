package pages;

import utils.WebHandlers;
import org.junit.Assert;

public class SauceProductPage {
    
    public void assertProductTitle(){
        WebHandlers.waitForElement("SauceProduct.productTitle");
    }
    public void selectFirstProduct() {
        WebHandlers.click("SauceProduct.firstProductAddToCart");
    }

    public void clickShoppingCart() {
        WebHandlers.click("SauceProduct.cartButton");
    }

}
