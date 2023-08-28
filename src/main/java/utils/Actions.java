package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions {

    public static Boolean elementIsDisplayed(WebDriver driver , long time , By element){
        Boolean statues;
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        statues = driver.findElement(element).isDisplayed();
        return  statues;
    }

    public  static void clickOnElement(WebDriver driver , long time , By element){

        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();

    }

    public  static void submitElement(WebDriver driver , long time , By element){

        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).submit();

    }

    public static  void  writeDataToElement(WebDriver driver , long time , By element , String data){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(data);
    }

    public static void forcedClick (WebDriver driver,By element){
        WebElement webElement = driver.findElement(element);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", webElement);
    }

    public static String getText (WebDriver driver,long time , By element ){
        WebDriverWait wait = new WebDriverWait(driver, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
       return driver.findElement(element).getText();

    }

    public static String getAttribute (WebDriver driver, By element , String attribute){

        return driver.findElement(element).getAttribute("");

    }

}
