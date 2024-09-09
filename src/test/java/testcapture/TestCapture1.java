package testcapture;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestCapture1 {
    WebDriver driver;
    @BeforeTest
    void setUp(){
       driver = new ChromeDriver();
    }
    @Test
    void testCapture() throws IOException {

        driver.get("http://120.72.107.188:3066/#banner");

        try {
            TakesScreenshot tks = ((TakesScreenshot) driver);
            TimeUnit.SECONDS.sleep(10);
            File srcFile = tks.getScreenshotAs(OutputType.FILE);
            File desFile = new File("target/pic1.png");
            FileUtils.copyFile(srcFile, desFile);
        }
        catch(InterruptedException e){
            e.printStackTrace();

        }

    }
    @AfterTest
    void quitTest(){
        driver.quit();
    }
}
