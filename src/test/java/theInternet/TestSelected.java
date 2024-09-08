package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelected {
    @Test
    void testSelect(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //Tìm phần tử <select> trên trang bằng cách sử dụng ID dropdown, và tạo một đối tượng Select để tương tác với nó. Select là một lớp trong Selenium cung cấp các phương thức để chọn các tùy chọn trong menu thả xuống.
        Select dropdown = new Select(driver.findElement(By.cssSelector("select#dropdown")));
        dropdown.selectByIndex(1);

        WebElement option1 = dropdown.getFirstSelectedOption();
        Assert.assertEquals(option1.getText(),"Option 1");

        dropdown.selectByIndex(2);
        WebElement option2 = dropdown.getFirstSelectedOption();
        Assert.assertEquals(option2.getText(), "Option 2");
        driver.quit();

    }
    @Test
    void verifySelectOption1Successfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select = new Select(driver.findElement(By.id("dropdown")));

        select.selectByIndex(1);
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 1']")).isSelected());

        driver.quit();
    }
    @Test
    void verifySelectMultipleOptionsSuccessfully() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");
        Select select = new Select(driver.findElement(By.id("fruits")));

        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");

        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());

        select.deselectAll();
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Orange']")).isSelected());
        Assert.assertFalse(driver.findElement(By.xpath("//option[.='Grape']")).isSelected());

    }
}
