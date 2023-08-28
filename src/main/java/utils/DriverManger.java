package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class DriverManger {
    String configFile = "src/main/resources/config.properties";

    public WebDriver setUpDriver() throws IOException {
        WebDriver driver = null;
        String driverName = PropertiesReader.readPropertyValue(configFile, "Browser");
        String headless = PropertiesReader.readPropertyValue(configFile, "HEADLESS");
        switch (driverName) {
            case "Chrome": // set up the web driver manger
                WebDriverManager.chromedriver().setup();
                if(headless.equals("true")){
                    ChromeOptions options = new ChromeOptions();
                    // set options to headless mode
                    options.addArguments("--headless");
                    // init web driver
                    driver = new ChromeDriver(options);
                }else {
                    // init web driver
                    driver = new ChromeDriver();
                }
                break;
            case "Firefox": // set up the web driver manger
                if(headless.equals("true")){
                    FirefoxOptions options = new FirefoxOptions();
                    // set options to headless mode
                    options.addArguments("--headless");
                    // init web driver
                    driver = new FirefoxDriver(options);
                }else {
                    // init web driver
                    driver = new FirefoxDriver();
                }
                break;
            default:
                System.out.println("Not Valid Driver");
        }




        return driver;
    }

}
