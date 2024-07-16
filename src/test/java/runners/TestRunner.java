package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features"
        ,glue={"steps"}
        ,tags ={"@Vysor1"}
        ,plugin = {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"}

)
public class TestRunner {
}
