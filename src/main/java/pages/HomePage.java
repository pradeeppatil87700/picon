package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BrowserUtils;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    // Constructor to initialize the WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By menCategory = By.xpath("(//div[@class='NavBarDesktop__Subtitle-sc-xsryom-0 izctWK']/span[text()='Men'])[1]");
    private By bagsLink = By.xpath("//a[contains(@href, '/bags-backpacks-men/pl/3kr')]/p[text()='Bags']");

    public void openHomePage(String url) {
        driver.get(url);
    }

    public String getHomePageTitle() {
        return BrowserUtils.getPageTitle(driver);
    }

    // Method to hover over the "Men" category
    public void hoverOverMenCategory() {
        BrowserUtils.hover(driver, driver.findElement(menCategory));
    }

    // Method to click on the "Bags" link after hovering over "Men"
    public void clickBags() {
        BrowserUtils.clickElement(driver, bagsLink, Duration.ofSeconds(10));
        BrowserUtils.waitForTitleContains(driver, "Bags", Duration.ofSeconds(10));
        System.out.println("Page Title after click: " + driver.getTitle());
    }
}
