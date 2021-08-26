package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class AmazonSearchPage {

    @FindBy(xpath = "//div[@class='a-section']")
    private WebElement filterSection;

    @FindBy(xpath = "//span[contains(@cel_widget_id, 'MAIN-SEARCH_RESULTS')]//span[contains(@class, 'a-text-normal')]")
    private List<WebElement> searchTitles;

    public AmazonSearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkTheTitle(WebDriver driver, String searchName) {
        Assert.assertEquals(driver.getTitle(), "Amazon.com : " + searchName);
    }

    public void checkSearchPageIsLoaded(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='a-section']")));
        Assert.assertTrue(filterSection.isDisplayed());
    }

    public void checkFirstTenResultsContainIphone() {
        for (int i = 0; i < 10; i++) {
            String title = searchTitles.get(i).getText();

            Assert.assertTrue(title.contains("iPhone"));


        }

    }


}
