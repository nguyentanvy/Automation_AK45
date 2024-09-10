package annotations;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLogin {
    @BeforeTest(groups = "group1")
    void beforeTest(){
        System.out.println("Before test login");
    }
    @Test(groups = "group1")
    @Parameters({"username","password"})
    public void testLogin(String username, String password){
        System.out.println("Username: "+ username);
        System.out.println("Password: "+password);
    }
    @Test
    void endTest(){
        System.out.println("End test");
    }

}
