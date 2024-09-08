package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testformlogin {

    @Test
    void testCheckbox(){
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        Assert.assertTrue(checkbox1.isSelected());
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        Assert.assertTrue(checkbox2.isSelected());
    }
}
