package utils;

import configs.MobileDriverConfigurations;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class MobileHandlers {

    static int waitTimeout = 10;
    static int handlerTimeout = 500;
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
            case "chain":
                return AppiumBy.iOSClassChain(locator);
            case "predicate":
                return AppiumBy.iOSNsPredicateString(locator);
            case "accessibility_id":
                return AppiumBy.accessibilityId(locator);
            case "uiautomator":
                return AppiumBy.androidUIAutomator(locator);
        }
        return null;
    }

    public static WebElement waitForElement(String locator){
        By by = findElementBy(locator);
        WebDriverWait wait = new WebDriverWait(MobileDriverConfigurations.getCurrentDriver(),Duration.ofSeconds(waitTimeout));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static WebElement waitForElementClickable(String locator){
        By by = findElementBy(locator);
        WebDriverWait wait = new WebDriverWait(MobileDriverConfigurations.getCurrentDriver(),Duration.ofSeconds(waitTimeout));
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static Boolean booleanElementDisplayed(String locator) {
        By by = findElementBy(locator);
        AppiumDriver appiumDriver = (AppiumDriver) MobileDriverConfigurations.getCurrentDriver();
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

    public static void swipeScreen(int startXPercentage, int startYPercentage, int endXPercentage, int endYPercentage, int duration){
        AppiumDriver appiumDriver = MobileDriverConfigurations.getCurrentDriver();

        int screenWidth = appiumDriver.manage().window().getSize().width;
        int screenHeight = appiumDriver.manage().window().getSize().height;

        int startX = (int) (screenWidth*((double)startXPercentage)/100);
        int startY = (int) (screenHeight*((double)startYPercentage)/100);
        int endX = (int) (screenHeight*((double)endXPercentage)/100);
        int endY = (int) (screenHeight*((double)endYPercentage)/100);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH,"finger");
        Sequence swipe = new Sequence(finger,1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger,Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(duration),PointerInput.Origin.viewport(),endX,endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        appiumDriver.perform(Collections.singletonList(swipe));
        System.out.println("Swiped");
    }

    public static void click(String locator){
        WebElement element = waitForElementClickable(locator);
        element.click();
    }
}
