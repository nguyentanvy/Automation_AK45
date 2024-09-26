package supports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;

public class Browser {
    private static WebDriver driver;
    public static void launchBrowser(String name){
        switch (name){
            case "Chrome":{

                driver =  new ChromeDriver();
                break;
            }
            case "Firefox": {
                driver =  new FirefoxDriver();
                break;
            }
            case "Edge" : {
                driver = new EdgeDriver();
                break;
            }
            case "Safari": {
                driver =  new SafariDriver();
                break;
            }
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quit(){
        if(driver != null){
            driver.quit();
        }
    }
    public static void visit(String url){
        driver.get(url);
    }

    public static void click(By locator){
        driver.findElement(locator).click();
    }
    public static void fill(By locator, CharSequence... withText){
        driver.findElement(locator).sendKeys(withText);
    }
    public static String getText(By locator){
        return driver.findElement(locator).getText();

    }
    public static void captureScreenShot(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File scrFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File desFile = new File(String.format("target/screenshot-%s-%s.png",name, System.currentTimeMillis()));
        try{
            FileUtils.copyFile(scrFile, desFile);
        } catch(IOException e){
            throw  new RuntimeException(e);
        }
    }
}
