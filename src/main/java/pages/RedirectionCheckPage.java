package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

public class RedirectionCheckPage {
    private WebDriver driver;

    // Constructor to initialize the WebDriver
    public RedirectionCheckPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for the elements on the page
    private By downloadButton = By.xpath("//div[contains(@class, 'VideoBanner__DownloadButton-sc-149azki-1') and contains(., 'Download the Meesho App')]");
    private By profileButton = By.xpath("//span[text()='Profile']");
    private By cartButton = By.xpath("//span[text()='Cart']");
    private By signUpButton = By.xpath("//span[text()='Sign Up']");
    private By loginButton = By.xpath("//a[@id='loginbutton']");  // Assuming the login button has this ID
    private By headerButton = By.xpath("//a[@data-position='header']");  // Assuming this is the header button

    // Open the Meesho website
    public void openPage(String url) {
        driver.get(url);
    }

    // Click the "Download the Meesho App" button
    public void clickDownloadButton() {
        BrowserUtils.clickElement(driver, downloadButton, Duration.ofSeconds(10));
    }

    // Click the "Profile" button
    public void clickProfile() {
        BrowserUtils.clickElement(driver, profileButton, Duration.ofSeconds(10));
    }

    // Click the "Cart" button
    public void clickCart() {
        BrowserUtils.clickElement(driver, cartButton, Duration.ofSeconds(10));
    }

    // Perform the Sign Up flow, handle the new tab, and click login then header button
    public void clickSignUp() {
        BrowserUtils.clickElement(driver, signUpButton, Duration.ofSeconds(10));

        // Get all window handles and switch to the new tab (if it opens)
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);

        if (tabs.size() > 1) {
            driver.switchTo().window(tabs.get(1)); // Switch to the new tab

            // Click the login button on the new tab
            BrowserUtils.clickElement(driver, loginButton, Duration.ofSeconds(10));
            System.out.println("Clicked the Login button.");

            // Navigate back to the main window (original tab)
            driver.close();
            driver.switchTo().window(tabs.get(0));
            System.out.println("Switched back to the original tab.");

            // Click the header button after coming back to the original tab
            BrowserUtils.clickElement(driver, headerButton, Duration.ofSeconds(10));
            System.out.println("Clicked the header button.");
        } else {
            System.out.println("Ensure the 'Sign Up' button triggers a new tab.");
        }
    }
}
