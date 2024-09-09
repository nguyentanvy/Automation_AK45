package argumentclick;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestArg {
    WebDriver driver = new ChromeDriver();
    @Test
    void TestArg1(){

        driver.get("https://tvn.gitbook.io/selenium-java/examples/click-element-via-js");
        WebElement button = driver.findElement(By.cssSelector("a[href='/selenium-java/examples/broken-link'].group"));
        clickElement(button);
        driver.quit();
    }
    private void clickElement(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeAsyncScript("argument[0].click;", element);
    }
}
