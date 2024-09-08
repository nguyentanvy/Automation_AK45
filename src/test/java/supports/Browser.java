package supports;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser {
    private static WebDriver driver;
    public static void launchBrowser(String name){
        switch (name){
            case "Chrome":{

                driver =  new ChromeDriver();
                break;
            }
            case "Firefox": {
                driver =  new FirefoxDriver();
                break;
            }
            case "Edge" : {
                driver = new EdgeDriver();
                break;
            }
            case "Safari": {
                driver =  new SafariDriver();
                break;
            }
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quit(){
        if(driver != null){
            driver.quit();
        }
    }
    public static void visit(String url){
        driver.get(url);
    }

    public static void click(By locator){
        driver.findElement(locator).click();
    }
    public static void fill(By locator, CharSequence... withText){
        driver.findElement(locator).sendKeys(withText);
    }
    public static String getText(By locator){
        return driver.findElement(locator).getText();

    }
}
