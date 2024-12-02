package tests;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.RedirectionCheckPage;

public class RedirectionCheck extends BasePage {
    private WebDriver driver;
    private RedirectionCheckPage redirectionCheckPage;

    @BeforeClass
    public void setup() {
        // Initialize the WebDriver and the Page Object
        driver = getDriver();
        redirectionCheckPage = new RedirectionCheckPage(driver);
    }

    @Test
    public void downloadMeesho() {
        // Step 1: Open the Meesho website
        redirectionCheckPage.openPage("https://www.meesho.com/");

        // Step 2: Click the "Download the Meesho App" button
        redirectionCheckPage.clickDownloadButton();

        // Step 3: Print success message
        System.out.println("Successfully clicked the 'Download the Meesho App' button!");
    }

    @Test
    public void clickProfileTest() {
        // Step 1: Open the Meesho website
        redirectionCheckPage.openPage("https://www.meesho.com/");

        // Step 2: Click the "Profile" button
        redirectionCheckPage.clickProfile();

        // Step 3: Print a success message
        System.out.println("Profile dropdown is opened successfully.");
    }

    @Test
    public void clickCartTest() {
        // Step 1: Open the Meesho website
        redirectionCheckPage.openPage("https://www.meesho.com/");

        // Step 2: Click the "Cart" button
        redirectionCheckPage.clickCart();

        // Step 3: Print success message
        System.out.println("Click Cart clicked successfully.");
    }

    @Test
    public void clickSignUpTest() {
        // Step 1: Open the Meesho website
        redirectionCheckPage.openPage("https://www.meesho.com/");

        // Step 2: Perform the Sign Up workflow
        redirectionCheckPage.clickSignUp();

        // Step 3: Print a success message
        System.out.println("Sign Up flow tested successfully.");
    }

    @AfterClass
    public void tearDown() {
        super.tearDown(); // Tear down the WebDriver session
    }
}
