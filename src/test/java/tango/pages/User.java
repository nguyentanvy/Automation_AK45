package tango.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import static tango.Untils.WaitLoadPage;

public class User {
    WebDriver driver;
    public User(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean checkUser(WebDriver driver){
        try {
            WebElement  textUser = WaitLoadPage(driver, 15, By.xpath("//span[.='TOTAL']"));
            return textUser.getText().contains("TOTAL");
        }
        catch (TimeoutException e){
            return false;
        }
    }
}
