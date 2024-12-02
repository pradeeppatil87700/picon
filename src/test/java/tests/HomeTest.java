package tests;
import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BasePage {
    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setup() {
        driver = getDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void verifyHomePage() {
        homePage.openHomePage("https://www.meesho.com/");
        String fetchedTitle = homePage.getHomePageTitle();
        System.out.println("Fetched Title is : " + fetchedTitle);
        Assert.assertTrue(fetchedTitle.contains("Meesho"), "Title does not match expected value!");
    }

    @Test
    public void verifyNavigationToBags() {
        // Step 1: Open the Meesho website
        homePage.openHomePage("https://www.meesho.com/");

        // Step 2: Hover over the "Men" category
        homePage.hoverOverMenCategory();

        // Step 3: Click the "Bags" link in the dropdown
        homePage.clickBags();

        // Step 4: Assert that the title contains "Bags"
        String pageTitle = driver.getTitle();
        System.out.println("Page title after clicking Bags: " + pageTitle);
        Assert.assertTrue(pageTitle.contains("Bags"), "Page title does not contain 'Bags'. Current title: " + pageTitle);
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
