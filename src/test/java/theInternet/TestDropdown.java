package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDropdown {
    @Test
    void testDropdown(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropdown= new Select(driver.findElement(By.cssSelector("select#dropdown")));
        dropdown.selectByIndex(1);
        WebElement option1 = dropdown.getFirstSelectedOption();
        Assert.assertEquals(option1.getText(),"Option 1");

        dropdown.selectByIndex(2);
        WebElement option2 = dropdown.getFirstSelectedOption();
        Assert.assertEquals(option2.getText(),"Option 2");
        driver.quit();

    }
}
