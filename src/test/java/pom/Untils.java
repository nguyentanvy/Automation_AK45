package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Untils {
    public static  boolean waitForElementDisplay(WebDriver driver, By by, int waitSecond){
        for (int i = 0; i < waitSecond/2 +1; i++) {
            try {
                if (driver.findElement(by).isDisplayed()){
                    return true;
                }
                Thread.sleep(waitSecond*1000);
            }catch (InterruptedException e){
                System.out.println("waiting element for display...");
                e.printStackTrace();

            }

        }
        return false;
    }
}
