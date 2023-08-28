package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import utils.DriverManger;

import java.io.IOException;

public class PricePlans {

    private WebDriver driver;
    private HomePage homePage;
    private DriverManger driverManger;

    @Before()
    public void setup() throws IOException {
        driverManger = new DriverManger();
        driver = driverManger.setUpDriver();
        homePage = new HomePage(driver);
    }

    @Given("I Navigate to STC Tv Website")
    public void iNavigateToSTCTvWebsite(){
        homePage.navigateToHomePage();
    }

    @When("I select {string}")
    public void selectCountry(String country){
        homePage.selectCountry(country);
    }

    @And("I set {string}")
    public void setLanguage(String language){
        homePage.selectLanguage(language);
    }

    @And("I should see country name in the selected language")
    public void assertCountryNameInSelectedLanguage(){
         String expectedName = homePage.getCountryNameExpectedValue();
         String actualName = homePage.getCountryNameActualValue();
        Assert.assertEquals(actualName , expectedName);

    }

    @And("I Should see lite plan price in country currency and selected language")
    public void assertLitePlanInSelectedLanguageAndCountry(){
        String expectedPrice = homePage.getLITEPriceExpectedValue();
        String actualPrice = homePage.getLITEPriceActualValue();
        Assert.assertEquals(actualPrice , expectedPrice);

    }
    @And("I Should see classic plan price in country currency and selected language")
    public void assertClassicPlanInSelectedLanguageAndCountry(){
        String expectedPrice = homePage.getCLASSICPriceExpectedValue();
        String actualPrice = homePage.getCLASSICPriceActualValue();
        Assert.assertEquals(actualPrice , expectedPrice);
    }
    @And("I Should see permium plan price in country currency and selected language")
    public void assertPermiumPlanInSelectedLanguageAndCountry(){
        String expectedPrice = homePage.getPREMIUMPriceExpectedValue();
        String actualPrice = homePage.getPREMIUMPriceActualValue();
        Assert.assertEquals(actualPrice , expectedPrice);
    }


    @After()
    public void quitBrowser() {
        driver.quit();

    }

}
