package annotations;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLogin {
    @Test
    @Parameters({"username","password"})
    public void testLogin(String username, String password){
        System.out.println("Username: "+ username);
        System.out.println("Password: "+password);
    }

}