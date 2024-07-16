package pages;

import utils.MobileHandlers;

public class VysorStartPage {


    public void checkPermission (){
        if (MobileHandlers.booleanElementDisplayed("VysorPage.allowPermission")){
            MobileHandlers.click("VysorPage.allowPermission");
        }
    }
    public void clickNextButton (){
        MobileHandlers.click("VysorPage.nextButton");
    }
    public void nextPageOnVysor (){
        System.out.println("About to Swipe");
        MobileHandlers.swipeScreen(70,50,20,50,50);
    }

    public void validateFirstPageView(){
        MobileHandlers.checkElementDisplayed("VysorPage.page1Title");
        MobileHandlers.checkElementDisplayed("VysorPage.page1SubTitle");
    }
    public void validateSecondPageView(){
        MobileHandlers.checkElementDisplayed("VysorPage.page2Title");
        MobileHandlers.checkElementDisplayed("VysorPage.page2SubTitle");
    }
    public void validateThirdPageView(){
        MobileHandlers.checkElementDisplayed("VysorPage.page3Title");
        MobileHandlers.checkElementDisplayed("VysorPage.page3SubTitle");
    }
    public void validateFourthPageView(){
        MobileHandlers.checkElementDisplayed("VysorPage.page4Title");
        MobileHandlers.checkElementDisplayed("VysorPage.page4SubTitle");
    }

}
