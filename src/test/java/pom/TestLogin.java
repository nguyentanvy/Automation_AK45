package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLogin {
    WebDriver driver;
    @BeforeTest
    void setUp(){
        driver = new ChromeDriver();
    }

    @DataProvider
    Object[][] testData(){
        return new Object[][]{
                {"tanvy","12345"},
                {"admin123", "342343"},
                {"tomsmith","SuperSecretPassword!"},
                {"admin22","333333"},
        };
    }

    @Test(dataProvider="testData")
    void readyTest(String username, String password) throws InterruptedException{
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

        Login logIn = new Login(driver);
        HomePage homePage = logIn.loginAction(username,password);
        if (homePage.isDisplayed()){
            System.out.println("Login Successfully");
        }else {
            System.out.println("Login fail");
        }
        Thread.sleep(5000);
    }

    @AfterTest
    void quit(){
        driver.quit();
    }
}
