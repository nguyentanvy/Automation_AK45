package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHover {
    @Test
    void TestHover1(){
        WebDriver driver = new ChromeDriver();
        Actions action = new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/hovers");
        WebElement user1 = driver.findElement(By.cssSelector(".example .figure:nth-of-type(1)"));
        action.moveToElement((user1)).perform();//Thực thi hành động hover, perform dùng để thực thi chuỗi hành động

        WebElement result = user1.findElement(By.cssSelector("h5"));
        String resultText= result.getText();
        Assert.assertEquals(resultText,"name: user1");
        driver.quit();

    }
}
