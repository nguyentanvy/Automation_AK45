package tango.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static tango.Untils.WaitLoadPage;

public class AddOns {
    WebDriver driver;
    public AddOns(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean checkAddons(WebDriver driver){
        try {
            WebElement textAddOns = WaitLoadPage(driver, 20, By.xpath("//h4[.='Subscription']"));
            return textAddOns.isDisplayed() && textAddOns.getText().contains("Subscription");
        }
        catch (TimeoutException e){
            return false;
        }
    }
}
