package steps;

import configs.WebDriverConfigurations;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import utils.LocatorRepository;

public class SetUpSteps {
    @Before
    public void startApp(Scenario scenario) throws Exception {
        LocatorRepository.load();
        new WebDriverConfigurations().setWebDriver();
        System.out.println("Driver instantiated");
    }
    @After
    public void afterScenario(Scenario scenario) {
        WebDriver driver = WebDriverConfigurations.getCurrentDriver();
        WebDriverConfigurations.removeDriver();
        driver.quit();

    }

}
