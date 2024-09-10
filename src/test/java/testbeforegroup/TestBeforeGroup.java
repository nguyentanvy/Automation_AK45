package testbeforegroup;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBeforeGroup {
    @BeforeTest
    void beforeTestGroup() {
        System.out.println("Before test");
    }

    @BeforeGroups(groups = {"group1"}) // Chỉ dành cho các nhóm cụ thể
    void beforeGroup(){
        System.out.println("before group");
    }

    @BeforeGroups("group2")
    void beforeGroup2(){
        System.out.println("before group 2");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("before method");
    }

    @Test(groups = "group1")
    void testFirst(){
        System.out.println("Method 1");
    }

    @Test(groups = {"group1"})
    void testSecond(){
        System.out.println("Method 2");
    }
}
