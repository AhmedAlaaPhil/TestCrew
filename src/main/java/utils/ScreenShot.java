package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {

    public static void takeScreenshot( WebDriver driver){
        // Take a screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Specify the destination path for the screenshot
        String destinationPath = "resources/screenshot.png";
        // Save the screenshot to the destination path
        try {
            FileUtils.copyFile(screenshotFile, new File(destinationPath));
            System.out.println("Screenshot saved to: " + destinationPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
