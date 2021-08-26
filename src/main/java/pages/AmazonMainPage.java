package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmazonMainPage {

    @FindBy(xpath = "//div[@cel_widget_id = 'desktop-hero-order']")
    private WebElement carouselElement;

    @FindBy(xpath = "//div/input[@type='text']")
    private WebElement searchTextBox;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;


    public AmazonMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void openURL(WebDriver driver) {
        driver.get("https://www.amazon.com/");
    }

    public void checkTheTitle(WebDriver driver) {
        Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");
    }

    public void checkMainPageIsLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@cel_widget_id = 'desktop-hero-order']")));
        Assert.assertTrue(carouselElement.isDisplayed());
    }

    public void searchFor(String input) {
        searchTextBox.sendKeys(input);
        searchButton.click();
    }

}
