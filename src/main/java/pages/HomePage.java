package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Actions;

import java.io.IOException;

import static utils.JsonReader.readJsonValue;

public class HomePage {


    ////////////// web driver instants //////////////
    private WebDriver driver;
    ////////////// page URL //////////////
    private String pageURL = "https://subscribe.stctv.com/sa-en";

    private String jsonDataFile = "src/test/resources/testData/HomePageTestData.json";

    ////////////// General Locator Section //////////////

    // locator for country selector button
    private By langBtn = By.id("translation-btn");
    private By countryBtn = By.id("country-btn");

    // locator for selected country name Text
    private By countryName = By.id("country-name");

    // locator for KSA
    private By ksaSelector = By.id("sa-contry-flag");

    // locator for Bahrain
    private By bhSelector = By.id("bh-contry-flag");

    // locator for Kuwait
    private By kwSelector = By.id("kw-contry-flag");

    ////////////// Plan Locator Section //////////////

    private By litePlanPrice[] = {By.id("currency-lite"), By.id("currency-لايت")};
    private By classicPlanPrice[] = {By.id("currency-classic"), By.id("currency-الأساسية")};
    private By premiumPlanPrice[] = {By.id("currency-premium"), By.id("currency-بريميوم")};

    ////////////// Index for Lang and Country //////////////
    // 0 means english 1 means arabic
    private int langIndex = 0;
    private String langOptions[] = {"En", "Ar"};
    // 0 means KSA 1 means KW 2 means BH
    private int countryIndex = 0;

    private String countyOptions[] = {"KSA", "KW", "BH"};

    long waitTime = 5;

    // constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;

    }

    // Function to navigate to the page
    public void navigateToHomePage() {

        driver.get(pageURL);
    }

    // Function to get the anchor element
    public Boolean getMainPageAnchorElement() {
        Boolean statues = false;
        statues = Actions.elementIsDisplayed(driver, waitTime, langBtn);
        return statues;
    }

    //function to click on select Language button change Language and update the Language index
    public void selectLanguage(String language) {
        if (language.equals("English") && langIndex == 0) {
            System.out.println("English is selected");
        } else if (language.equals("English")) {
            Actions.clickOnElement(driver, waitTime, langBtn);
            langIndex = 0;
        } else if (language.equals("Arabic") && langIndex == 1) {
            System.out.println("Arabic is selected");
        } else if (language.equals("Arabic")) {
            Actions.clickOnElement(driver, waitTime, langBtn);
            langIndex = 1;
        }
    }

    //function to click on select country button change country and update the country index
    public void selectCountry(String country) {
        if (country.equals("KSA") && countryIndex == 0) {
            System.out.println("KSA is selected");
        } else if (country.equals("KSA")) {
            Actions.clickOnElement(driver, waitTime, countryBtn);
            Actions.clickOnElement(driver, waitTime, ksaSelector);
            System.out.println("KSA is selected");
            countryIndex = 0;
        } else if (country.equals("KW") && countryIndex == 1) {
            System.out.println("KW is selected");
        } else if (country.equals("KW")) {
            Actions.clickOnElement(driver, waitTime, countryBtn);
            Actions.clickOnElement(driver, waitTime, kwSelector);
            System.out.println("KW is selected");
            countryIndex = 1;
        } else if (country.equals("BH") && countryIndex == 2) {
            System.out.println("BH is selected");
        } else if (country.equals("BH")) {
            Actions.clickOnElement(driver, waitTime, countryBtn);
            Actions.clickOnElement(driver, waitTime, bhSelector);
            System.out.println("BH is selected");
            countryIndex = 2;
        }
    }

    ////////////// functions to read Actual  Value from JSON file//////////////
    // function to get name of the selected country Expected Value

    public String getCountryNameActualValue() {

        return Actions.getText(driver,waitTime,countryName);
    }

    // function to get Lite price of the selected country Expected Value

    public String getLITEPriceActualValue() {
      return Actions.getText(driver,waitTime,litePlanPrice[langIndex]);
    }

    // function to get classic of the selected country Expected Value

    public String getCLASSICPriceActualValue() {
        return Actions.getText(driver,waitTime,classicPlanPrice[langIndex]);
    }

    // function to get permium of the selected country Expected Value

    public String getPREMIUMPriceActualValue() {
        return Actions.getText(driver,waitTime,premiumPlanPrice[langIndex]);
    }

    ////////////// functions to read Expected Value from JSON file//////////////


    // function to get name of the selected country Expected Value

    public String getCountryNameExpectedValue() {
        String jsonPathToName = getJsonPathForAssertions("name");
        String name = "";
        try {
            name = readJsonValue(jsonDataFile, jsonPathToName);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

    // function to get Lite price of the selected country Expected Value

    public String getLITEPriceExpectedValue() {
        String jsonPathToName = getJsonPathForAssertions("LITEPrice");
        String lite = "";
        try {
            lite = readJsonValue(jsonDataFile, jsonPathToName);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lite;
    }

    // function to get classic of the selected country Expected Value

    public String getCLASSICPriceExpectedValue() {
        String jsonPathToName = getJsonPathForAssertions("CLASSICPrice");
        String classic = "";
        try {
            classic = readJsonValue(jsonDataFile, jsonPathToName);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return classic;
    }

    // function to get permium of the selected country Expected Value

    public String getPREMIUMPriceExpectedValue() {
        String jsonPathToName = getJsonPathForAssertions("PREMIUMPrice");
        String permium = "";
        try {
            permium = readJsonValue(jsonDataFile, jsonPathToName);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return permium;
    }

    
    ////////////// private functions to create json path for data //////////////
    private String getJsonPathForAssertions(String key) {
        return String.format("%s.%s.%s", countyOptions[countryIndex], langOptions[langIndex], key);
    }
}
