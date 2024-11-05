package tango.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static tango.Untils.WaitLoadPage;

public class Messages {
    WebDriver driver;
    public Messages(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
    public boolean checkMessage (WebDriver driver){
        try {
            WebElement textMessage = WaitLoadPage(driver, 15, By.xpath("//div[@class='ant-tabs-tab-btn' and .='CHATS']"));
            return textMessage.isDisplayed();
        }
        catch (TimeoutException e){
            return false;
        }
    }
}
