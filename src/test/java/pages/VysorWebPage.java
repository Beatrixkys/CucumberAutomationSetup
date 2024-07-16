package pages;

import utils.MobileHandlers;

public class VysorWebPage {
    public void validateFirstLoad(){
        MobileHandlers.checkElementDisplayed("VysorWebPage.headerTitle");
        MobileHandlers.checkElementDisplayed("VysorWebPage.phoneImage");
        MobileHandlers.checkElementDisplayed("VysorWebPage.headerContent");
    }
    public void checkButtons(){
        MobileHandlers.checkElementDisplayed("VysorWebPage.downloadButton");
        MobileHandlers.checkElementDisplayed("VysorWebPage.watchVideo");
        MobileHandlers.checkElementDisplayed("VysorWebPage.learnMore");
    }
}
