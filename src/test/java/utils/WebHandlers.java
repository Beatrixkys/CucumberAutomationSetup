package utils;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configs.WebDriverConfigurations;

public class WebHandlers {

    static int waitTimeout = 10;
    static int handlerTimeout = 5000;
    static String errorMessage ="could not be performed";
 
    public static By findElementBy(String key) {
        String locator = LocatorRepository.get(key);
        Assert.assertNotNull(locator, "Unable to find object in Object Repository with key " + key);

        int index = locator.indexOf(":");
        String type = locator.substring(0,index );
        locator = locator.substring(index+1);

        switch (type) {
            case "xpath":
                return By.xpath(locator);
            case "css selector":
                return By.cssSelector(locator);
            case "id":
                return By.id(locator);
            case "tag name":
                return By.tagName(locator);
            case "name":
                return By.name(locator);
            case "link text":
                return By.linkText(locator);
            case "className":
                return By.className(locator);
        }
        return null;
    }

    public static WebElement waitForElement(String locator){
        By by = findElementBy(locator);
        System.out.println(by);
        WebDriverWait wait = new WebDriverWait(WebDriverConfigurations.getCurrentDriver(),Duration.ofSeconds(waitTimeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitForElementClickable(String locator){
        By by = findElementBy(locator);
        WebDriverWait wait = new WebDriverWait(WebDriverConfigurations.getCurrentDriver(),Duration.ofSeconds(waitTimeout));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

     public static Boolean booleanElementDisplayed(String locator) {
        By by = findElementBy(locator);
        WebDriver appiumDriver = (WebDriver) WebDriverConfigurations.getCurrentDriver();
        appiumDriver.manage().timeouts().implicitlyWait(Duration.ofMillis(handlerTimeout));
        try {
            Boolean isDisplayed = appiumDriver.findElement(by).isDisplayed();
            if(isDisplayed) System.out.println(locator + " element is displayed");
            else System.out.println(locator +" isElementDisplayedBoolean: FALSE");
            return isDisplayed;
        } catch(Exception e) {
            return false;
        }
    }
    public static void checkElementDisplayed(String locator) {
        try{
            Assert.assertTrue(locator+" is not displayed", booleanElementDisplayed(locator));
        }catch (StaleElementReferenceException staleException) {
            Assert.assertTrue(locator+" is not displayed",booleanElementDisplayed(locator));
        }
    }

    public static void click(String locator){
        WebElement element = waitForElementClickable(locator);
        element.click();
    }

    
    public static void enterText(String locator,String text){
        WebElement element = waitForElement(locator);
        element.click();
        element.sendKeys(text);
    }

    public static String getText(String locator){
        WebElement element = waitForElement(locator);
        return element.getText();
    }

    public static void scrollDown(){
        WebDriverConfigurations driver = new WebDriverConfigurations(); 
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }


}
