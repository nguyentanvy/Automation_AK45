package tango.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static tango.Untils.WaitLoadClick;
import static tango.Untils.WaitLoadPage;

public class Login {
     WebDriver driver;

    @FindBy(id = "username")
     WebElement byUserName;

    @FindBy(id="password")
     WebElement byPassword;

    @FindBy(css="button[type='submit']")
     WebElement byLoginBtn;

//    @FindBy(xpath = "//div[@id='rc-anchor-container']")
//    WebElement byCapCha;

    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public AdminDashboard LoginAction(String username, String password){
        WaitLoadPage(driver, 10, "input#username");
        byUserName.sendKeys(username);
        byPassword.sendKeys(password);
//        byCapCha.click();
        WaitLoadClick(driver, 20, byLoginBtn).click();
        return new AdminDashboard(driver);
    }

}
