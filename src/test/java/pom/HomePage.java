package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private  By logOut = By.cssSelector("a[href='/logout']");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public boolean isDisplayed(){
        if (Untils.waitForElementDisplay(driver,logOut, 10)){
            return true;

        }else {
            return false;
        }
    }
}
