package steps;

import configs.MobileDriverConfigurations;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import io.appium.java_client.AppiumDriver;
import utils.LocatorRepository;

public class SetUpSteps {
    String platform = "AndroidWeb";
    @Before
    public void startApp(Scenario scenario) throws Exception {
        LocatorRepository.load("platform");
        new MobileDriverConfigurations().getAppiumDriver(platform);
        System.out.println("Driver instantiated");
    }
    @After
    public void afterScenario(Scenario scenario) {
        AppiumDriver driver = MobileDriverConfigurations.getCurrentDriver();
        MobileDriverConfigurations.removeDriver();
        driver.quit();

    }

}
