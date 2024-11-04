package tango;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import tango.pages.*;
import tango.pages.AdminDashboard;
import tango.pages.Login;

import static tango.Untils.*;

public class TestCaseAdmin {
    private WebDriver driver;
    private AdminDashboard dashboard;
    private String username;
    private String password;

    // Constructor nhận tài khoản từ TestNG Factory
    public TestCaseAdmin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Factory(dataProvider = "Account")
    public static Object[] createInstances(String username, String password) {
        return new Object[]{new TestCaseAdmin(username, password)};
    }

    @DataProvider(name = "Account")
    public static Object[][] Account() {
        return new Object[][]{
                {"admin@gmail.com", "admin123"},
        };
    }

    @BeforeClass
    @Parameters({"browser"})
    public void Setup(String browser) {
//        driver = new EdgeDriver();
        driver = OptionBrowser(browser); // Gọi phương thức và gán giá trị cho driver
        driver.get("http://13.210.211.91:5177");
        driver.manage().window().maximize();

        try {
            Login login = new Login(driver);
            dashboard = login.LoginAction(username, password);
            Assert.assertTrue(dashboard.WaitAlert(driver));
        } catch (AssertionError e) {
            System.out.println("Dang nhap that bai" + e.getMessage());
            driver.quit();
            throw e;
        }
        // Thực hiện đăng nhập cho tài khoản hiện tại
    }

    @Test
    public void TestOverview() {
        String path = "/business-overview";
        NavigateToPage(path, driver);
        Overview overview = new Overview(driver);
        Assert.assertTrue(overview.checkOverview(driver), "Screen is not display");
        // Kiểm tra bổ sung cho trang Overview
    }
    @Test
    public void TestJobs(){
        String path = "/job-list";
        NavigateToPage(path, driver);
        Jobs jobs = new Jobs(driver);
        Assert.assertTrue(jobs.checkJobs(driver),"Jobs Screen is not display");
    }
    @Test
    public void TestUser(){
        String path = "/user";
        NavigateToPage(path, driver);
        User user = new User(driver);
        Assert.assertTrue(user.checkUser(driver),"User screen is not display");
    }
    @AfterClass(alwaysRun = true)
    public void TearDown() {
        if (driver != null) {
            driver.quit(); // Đóng driver sau khi tất cả kiểm thử hoàn tất cho tài khoản này
        }
    }
}