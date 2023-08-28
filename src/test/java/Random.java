import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class Random {

    @Test
    public void asc (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://subscribe.stctv.com/bh-ar");
        System.out.println(driver.findElement(By.id("country-name")).getText());
        Assert.assertEquals(driver.findElement(By.id("currency-الأساسية")).getText() , "3 \u202Bدينار بحريني/شهر");
        driver.quit();
    }
}
