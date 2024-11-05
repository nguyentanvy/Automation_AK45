package tango.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static tango.Untils.WaitLoadPage;

public class AdminContractor {
    WebDriver driver;
    public AdminContractor(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean checkAdminContractor (WebDriver driver){
        try {
            WebElement textContractor = WaitLoadPage(driver, 15, By.xpath("//p[.='Profile - Name']"));
            return textContractor.isDisplayed() && textContractor.getText().contains("Profile - Name");
        }
        catch (TimeoutException e){
            return false;
        }
    }
}
