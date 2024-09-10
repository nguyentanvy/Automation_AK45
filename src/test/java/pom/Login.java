package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver driver;
//    private  By byUserName = By.id("username");
//    private  By byPassWord = By.id("password");
//    private  By byLoginBtn = By.cssSelector("button[type='submit']");
//
        @FindBy(id = "username")
        WebElement byUserName;

        @FindBy(id="password")
        WebElement byPassWord;

        @FindBy(css="button[type='submit']")
        WebElement byLoginBtn;

    public Login(WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }
    public HomePage loginAction(String username, String password){
//        driver.findElement(byUserName).sendKeys(username);
//        driver.findElement(byPassWord).sendKeys(password);
//        driver.findElement(byLoginBtn).click();
            byUserName.sendKeys(username);
            byPassWord.sendKeys(password);
            byLoginBtn.click();
        return new HomePage(driver);
    }
}
