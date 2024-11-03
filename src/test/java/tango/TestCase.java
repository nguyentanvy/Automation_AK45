package tango;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tango.pages.AdminDashboard;
import tango.pages.Login;

//public class TestCase {
//    WebDriver driver;
//    AdminDashboard dashboard;
//     // Lưu trữ dashboard sau khi login
//
//    @DataProvider
//    Object[][] Account(){
//        return new Object[][]{
//                {"admin@gmail.com","admin123"},
//                {"testacc@gmail.com","123456"}
//
//        };
//    }
//    @BeforeMethod
//    void Setup() {
//        driver = new EdgeDriver();
//        driver.get("http://13.210.211.91:5177");
//
//        driver.manage().window().maximize();
//    }
//    @Test(dataProvider = "Account", priority = 1)
//    void TestLogin(String username, String password){
//        Login login = new Login(driver);
//        dashboard = login.LoginAction(username, password);
//        if(dashboard.WaitAlert(driver)){
//            Assert.assertTrue(dashboard.WaitAlert(driver));
//            System.out.println("Dang nhap thanh cong");
//        }
//        else {
//            System.out.println("Dang nhap khong thanh cong!");
//        }
//    }
//    @Test(priority = 2, dependsOnMethods = {"TestLogin"})
//    void TestOverview(){
//        String path="/business-overview";
//        NavigateToPage(path, driver);
//
//    }
//    @AfterMethod
//    void Quit(){
//        driver.quit();
//    }
//}


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tango.pages.AdminDashboard;
import tango.pages.Login;

import static tango.Untils.*;

public class TestCase {
    private WebDriver driver;
    private AdminDashboard dashboard;
    private String username;
    private String password;

    // Constructor nhận tài khoản từ TestNG Factory
    public TestCase(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Factory(dataProvider = "Account")
    public static Object[] createInstances(String username, String password) {
        return new Object[]{new TestCase(username, password)};
    }

    @DataProvider(name = "Account")
    public static Object[][] Account() {
        return new Object[][]{
                {"admin@gmail.com", "admin123"},
                {"testacc@gmail.com", "123456"},
                {"testacc@gmail.com", "1234563"}
        };
    }

    @BeforeClass
    @Parameters({"browser"})
    public void Setup(String browser) {
//        driver = new EdgeDriver();
        driver= OptionBrowser(browser); // Gọi phương thức và gán giá trị cho driver
        driver.get("http://13.210.211.91:5177");
        driver.manage().window().maximize();

        // Thực hiện đăng nhập cho tài khoản hiện tại
        Login login = new Login(driver);
        dashboard = login.LoginAction(username, password);
        Assert.assertTrue(dashboard.WaitAlert(driver), "Đăng nhập thất bại!");
    }

    @Test(priority = 1)
    public void TestOverview() {
        String path = "/business-overview";
        NavigateToPage(path, driver);
        // Kiểm tra bổ sung cho trang Overview
    }

    @AfterClass
    public void Quit() {
        driver.quit(); // Đóng driver sau khi tất cả kiểm thử hoàn tất cho tài khoản này
    }
}
