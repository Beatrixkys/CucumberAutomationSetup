package pages;

import utils.WebHandlers;
import org.junit.Assert;

public class SauceLoginPage {
    public void inputUsername(String username){
        WebHandlers.enterText("SauceLogin.usernameInput", username);
    }
    public void inputPassword(String password){
        WebHandlers.enterText("SauceLogin.passwordInput", password);
    }
    public void assertErrorMessage(String expected){
        String actual = WebHandlers.getText("SauceLogin.errorMessage").toLowerCase();
        Assert.assertEquals(expected.toLowerCase(),actual);
    }
    public void clickLogin(){
        WebHandlers.click("SauceLogin.loginButton");
    }
}
