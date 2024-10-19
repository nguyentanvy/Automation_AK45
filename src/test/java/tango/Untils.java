package tango;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Untils {
    public static Alert WaitLoadAlert(WebDriver driver, long time) {
        // Tạo WebDriverWait với tham số truyền vào là driver
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

        // Đợi cho đến khi alert xuất hiện
        return wait.until(ExpectedConditions.alertIsPresent());

        // Trả về đối tượng Alert
    }
    public static WebElement WaitLoadPage(WebDriver driver, long time, String css) {
        // Tạo WebDriverWait với tham số truyền vào là driver
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

        // Đợi cho đến khi element xuất hiện
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));

    }
    public static  WebElement ElementPage(WebDriver driver, String css){
       return driver.findElement(By.cssSelector(css));
    }
    public static void NavigateToPage(String page, WebDriver driver){
        driver.navigate().to("http://13.210.211.91:5177/admin"+page);
    }

}
