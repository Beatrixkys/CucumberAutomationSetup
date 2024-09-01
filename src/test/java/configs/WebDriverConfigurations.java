package configs;
import java.io.FileReader;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverConfigurations {
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static void setCurrentDriver(WebDriver driver) {
        tlDriver.set(driver);
    }
    public static WebDriver getCurrentDriver() {
        return tlDriver.get();
    }
    public static void removeDriver() {
        tlDriver.remove();
    }

    public Properties getRunPlatformConfig(String platform){
        Properties configurations = new Properties();
        try(FileReader reader = new FileReader("src/test/java//Properties/" + platform + ".properties")){
        configurations.load(reader);
            return configurations;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return configurations;
    }

    public WebDriver setWebDriver(){
        WebDriver driver = null; 
        Properties properties = getRunPlatformConfig("Web");
        switch (properties.getProperty("browser").toLowerCase()){
            case "chrome" : 
                driver =  new ChromeDriver(); 
                break; 
            case "firefox":
                driver = new FirefoxDriver(); 
                break; 
            default : 
        }
        setCurrentDriver(driver); 
        driver.get(properties.getProperty("url"));
        return driver;
    }

}
