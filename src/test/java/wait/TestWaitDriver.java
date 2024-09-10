package wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestWaitDriver {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @Test
    void startTest(){
        driver.get("http://120.72.107.188:3066/");
        driver.manage().window().maximize();

        WebElement subcribe = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='SUBCRIBE']/ancestor::a")));
        subcribe.click();
    }
    @AfterClass
    void Quit(){
        driver.quit();
    }
}
