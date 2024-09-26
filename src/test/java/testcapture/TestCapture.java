package testcapture;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import supports.Browser;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestCapture {
    WebDriver driver;
    @Test
    void testDriver()  throws IOException {
         driver = new ChromeDriver();
        driver.get("https://tvn.gitbook.io/selenium-java/examples/5.15.-capture-screenshot");
        try {
            TakesScreenshot Trs = ((TakesScreenshot) driver);
            TimeUnit.SECONDS.sleep(10);
            File scrFile = Trs.getScreenshotAs(OutputType.FILE);//File srcFile = scrShot.getScreenshotAs(OutputType.FILE);: Chụp ảnh màn hình của trang web và lưu kết quả vào một tệp tạm thời dưới dạng đối tượng File. OutputType.FILE chỉ định rằng đầu ra sẽ là một tệp.
            File desFile = new File("target/selenium.png"); // Tạo đối tượng file đại diện cho tệp  selenium chứa vị trị muốn lưu ảnh.
            FileUtils.copyFile(scrFile,desFile);// Sao chép tệp từ src đến đường dẫn.
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }


    }
    @AfterMethod
    void captureScreen(ITestResult iTestResult){
        if (!iTestResult.isSuccess()){
            Browser.captureScreenShot(iTestResult.getInstanceName());
        }
    }
//    @AfterMethod
//    void testCapture(ITestResult testResult) throws IOException {
//        if(!testResult.isSuccess()){
//            File file = ((TakesScreenshot) new ChromeDriver()).getScreenshotAs(OutputType.FILE);
//            File DestFile=new File("./target/screenshot/"
//                    +testResult.getMethod().getMethodName()
//                    +  "-"
//                    +System.currentTimeMillis()+".png");
//
//            FileUtils.copyFile(file, DestFile);
//        }
//
//
//    }
    @AfterTest
    void quit(){
    driver.quit();
    }
}


