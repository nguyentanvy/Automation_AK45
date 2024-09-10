package todoMvc;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestCase11 {
    WebDriver driver;
    @Test
    void TestTodoAdd() throws InterruptedException{
        driver =  new ChromeDriver();
        driver.get("https://todomvc.com/examples/react/dist/#/");
        driver.manage().window().maximize();
        String value = "Vyz";
        WebElement input1 = driver.findElement(By.cssSelector(".input-container input#todo-input"));
        input1.sendKeys(value + Keys.ENTER);
//
        WebElement result = driver.findElement(By.xpath("//label[@data-testid='todo-item-label']"));
        System.out.println("kq: "+result.getText());
        Assert.assertEquals(result.getText(),value);
        Thread.sleep(10000);
    }
    @AfterMethod
    void Quit(){
        driver.quit();
    }
}
