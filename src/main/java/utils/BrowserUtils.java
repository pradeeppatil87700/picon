package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BrowserUtils {

    // Wait for an element to be visible
    public static WebElement waitForVisibility(WebDriver driver, By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for an element to be clickable
    public static WebElement waitForClickability(WebDriver driver, By locator, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    

    // Wait for title to contain a specific text
    public static void waitForTitleContains(WebDriver driver, String titleFragment, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.titleContains(titleFragment));
    }

    // Hover over an element
    public static void hover(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // Get page title
    public static String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    // Click an element after waiting for it to be clickable
    public static void clickElement(WebDriver driver, By locator, Duration timeout) {
        WebElement element = waitForClickability(driver, locator, timeout);
        element.click();
    }
}
