package todoMvc;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase11 {
    @Test
    void TestTodoAdd(){
        WebDriver driver =  new ChromeDriver();
        driver.get("https://todomvc.com/examples/react/dist/#/");
        String value = "Vyz";
        WebElement input1 = driver.findElement(By.cssSelector(".input-container input#todo-input"));
        input1.sendKeys(value + Keys.ENTER);
//
        WebElement result = driver.findElement(By.xpath("//label[@data-testid='todo-item-label']"));
        System.out.println("kq: "+result.getText());
        Assert.assertEquals(result.getText(),value);
        driver.quit();
    }
}
