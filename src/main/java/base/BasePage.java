package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

public class BasePage {
    protected WebDriver driver;

    // Initialize WebDriver based on config.properties
    public void initializeDriver() {
        String browser = ConfigReader.getProperty("browser");

        // Choose driver path based on the browser
        String driverPath = browser.equalsIgnoreCase("chrome") 
                            ? ConfigReader.getProperty("chromeDriverPath") 
                            : ConfigReader.getProperty("firefoxDriverPath");

        // Set system property and initialize driver based on the browser
        if ("chrome".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
    }

    // Getter for WebDriver
    public WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    // Quit driver
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
