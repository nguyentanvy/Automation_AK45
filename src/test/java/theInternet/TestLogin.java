package theInternet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestLogin {
    @Test
    public void testLogin(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
//        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
//        driver.findElement(By.cssSelector("button[type='submit']")).click();
//        driver.findElement(By.className("radius")).click();
//        driver.findElement(By.cssSelector(".radius")).click();
//        driver.findElement(By.xpath("//*[.=' Login']")).click();
//        driver.findElement(By.xpath("//*[contains(.,'Login'])")).click();
//        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure");
        Assert.assertTrue(driver.findElement(By.className("success")).getText().contains("You logged into a secure area"));
    }
    @Test
    void dragDropTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        actions.dragAndDrop(source,target).perform();

        Assert.assertTrue(driver.findElement(By.cssSelector("#column-a header")).getText().contains("B"));
        Assert.assertTrue(driver.findElement(By.cssSelector("#column-b header")).getText().contains("A"));
        driver.quit();
    }

    @Test
    void horizontalSliderTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");

        Actions actions = new Actions(driver);
        WebElement input = driver.findElement(By.cssSelector(".sliderContainer input"));
        int width = input.getSize().getWidth();

        actions.clickAndHold(input)
                .moveByOffset(width,0)
                .perform();
        try {
            TimeUnit.SECONDS.sleep(5);
            Assert.assertEquals(driver.findElement(By.cssSelector("span#range")).getText(),"5");
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    @Test
    void keyPressTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");

        Actions actions = new Actions(driver);

        actions.keyDown(Keys.ESCAPE).perform();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(),"You entered: ESCAPE");
    }
    @Test
    void scrollTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        Actions actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
//            actions.scrollByAmount(0,1000)
//                    .perform();

            //to perform Scroll on application using Selenium
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)", "");
            Thread.sleep(1000);
        }

    }
    @Test
    void captureScreenShot(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File(String.format("target/screenshot-%s-%s.png", "context-menu", System.currentTimeMillis()));
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
