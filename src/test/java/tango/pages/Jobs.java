package tango.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static tango.Untils.WaitLoadPage;

public class Jobs {
    WebDriver driver;
    public Jobs(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean checkJobs(WebDriver driver){
        try {
            WebElement textJobs = WaitLoadPage(driver, 10, By.xpath("//span[.='TOTAL JOBS']"));
            return textJobs.getText().contains("TOTAL JOBS");
        }
        catch (TimeoutException e){
            return false;
        }

    }
}
