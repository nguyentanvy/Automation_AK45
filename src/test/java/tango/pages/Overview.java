package tango.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static tango.Untils.WaitLoadPage;

public class Overview {
    WebDriver driver;

    public Overview(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean checkOverview(WebDriver driver) {
        try {
            WebElement textOverview = WaitLoadPage(driver,10, By.xpath("//article[.='Business Overview']"));
            return textOverview.getText().contains("Business Overview");
        } catch (TimeoutException e) {
            return false;
        }

    }

}
