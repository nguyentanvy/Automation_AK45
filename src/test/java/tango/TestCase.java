package tango;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tango.pages.AdminDashboard;
import tango.pages.Login;

public class TestCase {
    WebDriver driver;
     // Lưu trữ dashboard sau khi login

    @DataProvider
    Object[][] Account(){
        return new Object[][]{
                {"admin@gmail.com","admin123"}

        };
    }
    @BeforeClass
    void Setup() {
        driver = new EdgeDriver();
        driver.get("http://13.210.211.91:5177");

        driver.manage().window().maximize();
    }
    @Test(dataProvider = "Account")
    void TestLogin(String username, String password){
        Login login = new Login(driver);
        AdminDashboard dashboard = login.LoginAction(username, password);
        if(dashboard.WaitAlert(driver)){
            Assert.assertTrue(dashboard.WaitAlert(driver));
            System.out.println("Dang nhap thanh cong");
        }
        else {
            System.out.println("Dang nhap khong thanh cong!");
        }
    }
    @Test
    void TestOverview(){

    }
    @AfterClass
    void Quit(){
        driver.quit();
    }
}
