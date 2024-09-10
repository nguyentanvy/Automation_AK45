package todoMvc;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase13 {
    WebDriver driver;
    @Test
    void TestDelete() throws InterruptedException{
        driver =  new ChromeDriver();
        driver.get("https://todomvc.com/examples/react/dist/#/");

        driver.manage().window().maximize();
        String value = "Vyz";
        String value1= "So Good";
        Actions action = new Actions(driver);
        WebElement input1 = driver.findElement(By.cssSelector(".input-container input#todo-input"));
        input1.sendKeys(value + Keys.ENTER);
        input1.sendKeys(value1+ Keys.ENTER);
        List<WebElement> listTodo = driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
        int FirstSize = listTodo.size();
        WebElement liHover = driver.findElement(By.xpath("//ul[@class='todo-list']/li[2]"));
        WebElement delete = liHover.findElement(By.cssSelector("button.destroy"));
        action.moveToElement(liHover).perform();
        delete.click();

        listTodo = driver.findElements(By.xpath("//ul[@class='todo-list']/li"));
        int PrevSize = listTodo.size();


        Thread.sleep(5000);
        Assert.assertEquals(FirstSize-1,PrevSize, "Element was deleted successfully.");

    }
    @AfterMethod
    void Quit(){
        driver.quit();
    }
}
