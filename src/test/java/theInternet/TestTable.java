package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class TestTable {
    private Person toPerson(WebElement element){
        String lastName = element.findElements(By.tagName("td")).get(0).getText();
        String firstName = element.findElements(By.tagName("td")).get(1).getText();
        String email = element.findElements(By.tagName("td")).get(2).getText();
        Float due = Float.valueOf(element.findElements(By.tagName("td")).get(3).getText().trim().replace("$",""));
        String website = element.findElements(By.tagName("td")).get(4).getText();

        return new Person(lastName,firstName,email,due,website);
    }
    @Test
    void testTable1(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1' and @class='tablesorter']/tbody/tr"));
        List<Person> persons = rows.stream().map(this::toPerson).toList();

        Person largestDue = persons.stream()
                .max(Comparator.comparing(Person::getDue))
                .orElseThrow(NoSuchElementException::new);
        Assert.assertEquals(String.format("%s %s", largestDue.getLastName(),largestDue.getFirstName()), "Doe Jason");
        System.out.println("Largest due:" + largestDue.getDue());
        driver.quit();
    }
}
