package calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculator {
    @Test
    void TestCase(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.calculator.net/bmi-calculator.html");

        double heightInMeters = 182;
        double weightInKg = 70;
        WebElement element = driver.findElement(By.cssSelector("li#menuon a"));
        element.click();
        WebElement age = driver.findElement(By.cssSelector("input#cage"));
        age.clear();
        age.sendKeys("26");

        WebElement  gender = driver.findElement(By.cssSelector("td label.cbcontainer:first-child"));
        gender.click();

        WebElement height = driver.findElement(By.cssSelector("input#cheightmeter"));
        height.clear();
        height.sendKeys(String.valueOf(heightInMeters));

        WebElement weight = driver.findElement(By.cssSelector("input#ckg"));
        weight.clear();
        weight.sendKeys(String.valueOf(weightInKg));

        driver.findElement(By.xpath("//input[@type='submit' and @value='Calculate']")).submit();

        double bmi = weightInKg / (heightInMeters * heightInMeters*0.0001);
        String result = String.format("%.1f", bmi);

        System.out.println(result);
        Assert.assertTrue(driver.findElement(By.cssSelector(".rightresult .bigtext b")).getText().contains(result));

        driver.quit();

    }
    @Test
    void verifyBMIValue(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.calculator.net/bmi-calculator.html");

        double heightInMeters = 182;
        double weightInKg = 70;

        driver.findElement(By.cssSelector("li#menuon a")).click();
        driver.findElement(By.cssSelector("input[value=Clear]")).click();

        driver.findElement(By.cssSelector("input#cage")).sendKeys("26");
        driver.findElement(By.cssSelector("td label.cbcontainer:first-child")).click();
        driver.findElement(By.cssSelector("input#cheightmeter")).sendKeys(String.valueOf(heightInMeters));
        driver.findElement(By.cssSelector("input#ckg")).sendKeys(String.valueOf(weightInKg));

        driver.findElement(By.xpath("//input[@type='submit' and @value='Calculate']")).submit();

        double bmi = weightInKg / (heightInMeters * heightInMeters*0.0001);

        String expectedResult = String.format("%.1f", bmi);
        String actualResult = driver.findElement(By.cssSelector(".rightresult .bigtext b")).getText();

        Assert.assertTrue(actualResult.contains(expectedResult));

        driver.quit();
    }

}
