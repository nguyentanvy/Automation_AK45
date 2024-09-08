package theInternet;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAlert {
    @Test
    void TestCase07(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        Alert alert1 = driver.switchTo().alert();
        Assert.assertEquals(alert1.getText(),"I am a JS Alert");
        alert1.accept();

        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        Alert alert2 = driver.switchTo().alert();
        Assert.assertEquals(alert2.getText(),"I am a JS Confirm");
//        alert2.accept();
        alert2.dismiss();
        String AfterDismiss = driver.findElement(By.cssSelector("p#result")).getText().trim();
        Assert.assertEquals(AfterDismiss,"You clicked: Cancel");



        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        Alert alert3 = driver.switchTo().alert();
        Assert.assertEquals(alert3.getText(), "I am a JS prompt");



        alert3.sendKeys("Nguyen Tan Vy la so 1");
        alert3.accept();
        String result = driver.findElement(By.cssSelector("p#result")).getText().trim();
        Assert.assertEquals(result,"You entered: Nguyen Tan Vy la so 1");

        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        Alert alert3_1 = driver.switchTo().alert();
        alert3_1.dismiss();
        String resultAfterDismiss = driver.findElement(By.cssSelector("p#result")).getText().trim();
        Assert.assertEquals(resultAfterDismiss,"You entered: null");


        driver.quit();



    }
}
