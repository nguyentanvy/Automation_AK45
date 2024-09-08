package calculator;

import org.testng.Assert;
import org.testng.annotations.*;

import static supports.Browser.launchBrowser;
import static supports.Untils.calculateBmi;

import page.BodyMassIndexPage;
import supports.Browser;

public class BodyMassIndexTest {

    @BeforeMethod
    @Parameters({"browser"})
    void setup(String browser){
        launchBrowser(browser);
    }
    @DataProvider
    Object[][] bmiTestData(){
        return new Object[][]{
                {"26",182,70,"male"},
                {"25",182,45,"male"},
                {"25",182,45,"male"},
                {"25",182,45,"male"},

        };
    }


    @Test(dataProvider = "bmiTestData")
    void verifyBMIValue(String age, double height, double weight, String gender){
        BodyMassIndexPage bodyMassIndexPage = new BodyMassIndexPage();
        bodyMassIndexPage
                .open()
                .selectMetricTab()
                .clearForm();

        bodyMassIndexPage.fillForm(age, height, weight, gender);

        String expectedResult = calculateBmi(weight,height);
        String actualResult = bodyMassIndexPage.getResult();

        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @AfterMethod
    void tearDown(){
        Browser.quit();
    }
}
