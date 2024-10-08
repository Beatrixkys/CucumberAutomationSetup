package configs;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileReader;
import java.net.URL;
import java.util.Properties;

public class MobileDriverConfigurations {
    private static ThreadLocal<AppiumDriver> tlDriver = new ThreadLocal<>();
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

    public static void setCurrentDriver(AppiumDriver driver) {
        tlDriver.set(driver);
    }
    public static AppiumDriver getCurrentDriver() {return tlDriver.get();}
    public static void removeDriver() {
        tlDriver.remove();
    }

    public AndroidDriver setAndroidDriver(){
            DesiredCapabilities cap = new DesiredCapabilities();
            AndroidDriver driver = null;
            Properties properties = getRunPlatformConfig("android");
            try{
                cap.setCapability("appPackage",properties.getProperty("appPackage"));
                cap.setCapability("appActivity",properties.getProperty("appActivity"));
                cap.setCapability("platformName","android");
                cap.setCapability("udid", properties.getProperty("udid"));
                cap.setCapability("automationName", "UiAutomator2");
                URL url = new URL("http://127.0.0.1:4723/");
                driver = new AndroidDriver(url, cap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return driver;
        }

        //Run appium with appium --allow-insecure chromedriver_autodownload
    public AndroidDriver setWebAndroidDriver(){
        DesiredCapabilities cap = new DesiredCapabilities();
        AndroidDriver driver = null;
        Properties properties = getRunPlatformConfig("android");
        try{
            cap.setCapability(CapabilityType.BROWSER_NAME,"Chrome");
            cap.setCapability("udid", properties.getProperty("udid"));
            cap.setCapability("automationName", "UiAutomator2");
            URL url = new URL("http://127.0.0.1:4723/");
            driver = new AndroidDriver(url, cap);
            driver.get(properties.getProperty("url"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }

    public AppiumDriver getAppiumDriver(String platform){
        AppiumDriver appiumDriver = null;
        switch (platform.toLowerCase()) {
            case "android":
                appiumDriver = setAndroidDriver();
                break;
            case "androidweb":
                appiumDriver = setWebAndroidDriver();
                break;
            default:
        }
        setCurrentDriver(appiumDriver);
        return appiumDriver;
    }


}





