package tango;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Untils {
//    private static WebDriver driver;
    public static Alert WaitLoadAlert(WebDriver driver, long time) {
        // Tạo WebDriverWait với tham số truyền vào là driver
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

        // Đợi cho đến khi alert xuất hiện
        return wait.until(ExpectedConditions.alertIsPresent());

        // Trả về đối tượng Alert
    }
    public static WebElement WaitLoadPage(WebDriver driver, long time, By locator) {
        // Tạo WebDriverWait với tham số truyền vào là driver
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

        // Đợi cho đến khi element xuất hiện
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public static WebElement WaitLoadClick(WebDriver driver, long time, WebElement we) {
        // Tạo WebDriverWait với tham số truyền vào là driver
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));

        // Đợi cho đến khi element xuất hiện
        return wait.until(ExpectedConditions.elementToBeClickable(we));

    }
    public static  WebElement ElementPage(WebDriver driver, String css){
       return driver.findElement(By.cssSelector(css));
    }
    public static void NavigateToPage(String page, WebDriver driver){
        driver.navigate().to("http://13.210.211.91:5177"+page);
    }
    public static WebDriver OptionBrowser(String browser){
        WebDriver driver = null; // Khởi tạo driver ở đây
        switch (browser){
            case "Chrome":{
                driver = new ChromeDriver();
                break;
            }
            case "Edge":{
                driver = new EdgeDriver();
                break;
            }
            case  "Firefox":{
                driver = new FirefoxDriver();
                break;
            }
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);

        }
        return driver;

    }

}
