package todoMvc;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase14 {
    @Test
    void TestUpdate(){
        WebDriver driver =  new ChromeDriver();
        driver.get("https://todomvc.com/examples/react/dist/#/");
        String value = "Vyz";
        String value1= "So Good";
        Actions action = new Actions(driver);
        WebElement input1 = driver.findElement(By.cssSelector(".input-container input#todo-input"));
        input1.sendKeys(value + Keys.ENTER);
        input1.sendKeys(value1+ Keys.ENTER);
        WebElement input = driver.findElement(By.xpath("//ul[@class='todo-list']/li[2]"));
        String before = input.getText();

        action.doubleClick(input).perform();
        String newValue ="and handsome";
        input.sendKeys(newValue +Keys.ENTER);
        String after = input.getText();

        Assert.assertNotEquals(before,after);

        driver.quit();
    }
}
