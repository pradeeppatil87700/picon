package tests;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomeTest extends BasePage {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        initializeDriver();
        driver = getDriver();
    }

    @Test
    public void verifyHomePage() {
        driver.get("https://www.flipkart.com/");
        
        // Corrected the actualTitle assignment to fetch the page title correctly
        String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
        String actualTitle = driver.getTitle();  // Corrected this line
        Assert.assertEquals(actualTitle, expectedTitle, "Home page title does not match!");
        System.out.println("Test Executed Successfully done done");
    }

    @AfterClass
    public void tearDown() {
        super.tearDown();
    }
}
