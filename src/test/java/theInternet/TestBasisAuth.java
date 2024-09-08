package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBasisAuth {
    @Test
    void basicAuthen(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("Congratulations! You must have the proper credentials."));
        driver.quit();
    }
}
