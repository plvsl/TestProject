import base.TestBase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AmazonMainPage;
import pages.AmazonSearchPage;

public class TestClass extends TestBase {

    private AmazonMainPage amazonMainPage;
    private AmazonSearchPage amazonSearchPage;


    @BeforeTest
    public void beforeTest() {
        amazonMainPage = new AmazonMainPage(driver);
        amazonSearchPage = new AmazonSearchPage(driver);
    }

    @Test
    public void test1() {
        amazonMainPage.openURL(driver);
        amazonMainPage.checkTheTitle(driver);
        amazonMainPage.checkMainPageIsLoaded(driver);
    }

    @Test
    public void test2() {
        amazonMainPage.openURL(driver);
        amazonMainPage.searchFor("Iphone");
        amazonSearchPage.checkSearchPageIsLoaded(driver);
        amazonSearchPage.checkTheTitle(driver, "Iphone");
        amazonSearchPage.checkFirstTenResultsContainIphone();
    }

}
