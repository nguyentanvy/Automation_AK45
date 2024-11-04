package tango.pages;

import org.openqa.selenium.*;

import static tango.Untils.WaitLoadPage;

public class AdminDashboard {
     WebDriver driver;

    public AdminDashboard(WebDriver driver){
        this.driver = driver;
    }
    public boolean WaitAlert(WebDriver driver){
        try{
        WebElement alert = WaitLoadPage(driver,10, By.cssSelector(".ant-notification-notice-message"));
        return alert.getText().contains("Login Success");
        } catch (TimeoutException e) {
        // Nếu không có alert xuất hiện, trả về false
        return false;
        }
    }


}
