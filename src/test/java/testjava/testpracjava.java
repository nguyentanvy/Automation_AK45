package testjava;

import checknugyenamak46.Main;
import com.beust.ah.A;
import nhamnhuan.Mian;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testpracjava {
    @Test
    void TestNamNhuan(){
        Assert.assertTrue(Mian.checkYear(2032));
    }
    @Test
    void TestNguyenAm(){
        Assert.assertTrue(Main.checknguyenam(""));
    }
}
