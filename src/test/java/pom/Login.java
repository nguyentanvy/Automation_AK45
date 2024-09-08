package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;
    private  By byUserName = By.id("username");
    private  By byPassWord = By.id("password");
    private  By byLoginBtn = By.cssSelector("button[type='submit']");

    public Login(WebDriver driver){
        this.driver =driver;
    }
    public HomePage loginAction(String username, String password){
        driver.findElement(byUserName).sendKeys(username);
        driver.findElement(byPassWord).sendKeys(password);
        driver.findElement(byLoginBtn).click();
        return new HomePage(driver);
    }
}
