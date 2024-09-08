package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHtmlFrame {
    @Test
    void TestHtml(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");// có thể chạy bằng index

        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.cssSelector("html body")).getText());
        Assert.assertTrue(driver.findElement(By.cssSelector("html body")).getText().contains("LEFT"));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.xpath("//html/body")).getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.cssSelector(" html body")).getText());

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.cssSelector("html body")).getText());
        driver.quit();
    }
}
