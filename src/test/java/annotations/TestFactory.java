package annotations;

import org.testng.annotations.Test;

public class TestFactory {
    private int param;
    TestFactory(int param){
        this.param = param;
    }
    @Test
    void showTest(){
        System.out.println("Tham so truyen vao la:" +param);
    }
}
