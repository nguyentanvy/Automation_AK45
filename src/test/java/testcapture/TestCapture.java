package testcapture;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestCapture {
    @Test
    void testDriver()  throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://120.72.107.188:3066/#banner");
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
    @AfterTest
    void testCapture(ITestResult testResult) throws IOException {
        if(!testResult.isSuccess()){
            File file = ((TakesScreenshot) new ChromeDriver()).getScreenshotAs(OutputType.FILE);
            File DestFile=new File("./target/screenshot/"
                    +testResult.getMethod().getMethodName()
                    +  "-"
                    +System.currentTimeMillis()+".png");

            FileUtils.copyFile(file, DestFile);
        }

    }
}
