package todoMvc;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestCase12 {
    WebDriver driver;
    @Test
    void TestComplete() throws InterruptedException{
        driver =  new ChromeDriver();
        driver.get("https://todomvc.com/examples/react/dist/#/");
        driver.manage().window().maximize();
        String value = "Vyz";
        WebElement input1 = driver.findElement(By.cssSelector(".input-container input#todo-input"));
        input1.sendKeys(value + Keys.ENTER);

        WebElement checkbox = driver.findElement(By.xpath("//ul/li[1]//input[@type='checkbox']"));
        checkbox.click();

        WebElement completed  = driver.findElement(By.xpath("//li/a[.='Completed']"));
        completed.click();
        WebElement result = driver.findElement(By.xpath("//main/ul/li[1]//label[@data-testid='todo-item-label']"));

        Thread.sleep(5000);
        Assert.assertEquals(result.getText(),value);


    }
    @AfterMethod
    void Quit(){
        driver.quit();
    }
}
