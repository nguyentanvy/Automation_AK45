package tango.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static tango.Untils.WaitLoadPage;

public class AdminAdviser {
    WebDriver driver;
    public AdminAdviser(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean checkAdminAdviser (WebDriver driver){
        try {
            WebElement textAdviser = WaitLoadPage(driver, 15, By.xpath("//p[.='Profile - Name']"));
            return textAdviser.getText().contains("Profile-Name");
        }
        catch (TimeoutException e){
            return false;
        }
    }
}
