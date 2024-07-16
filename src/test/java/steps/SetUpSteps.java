package steps;

import configs.MobileDriverConfigurations;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import utils.LocatorRepository;

public class SetUpSteps {
    @Before
    public void startApp(Scenario scenario) throws Exception {
        LocatorRepository.load("android");
        new MobileDriverConfigurations().getAppiumDriver("Android");
        System.out.println("Driver instantiated");

    }
    @After
    public void afterScenario(Scenario scenario) {
        AppiumDriver driver = MobileDriverConfigurations.getCurrentDriver();
        MobileDriverConfigurations.removeDriver();
        driver.quit();

    }

}
