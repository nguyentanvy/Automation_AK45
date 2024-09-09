package annotations;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestListenersExample {

    @Test
    public void testMethod1() {
        System.out.println("Executing test method 1");
    }

    @Test
    public void testMethod2() {
        System.out.println("Executing test method 2");
        assert false : "Intentional failure for demonstration";
    }
}

class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        // Additional actions like taking a screenshot
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    // You can implement other methods as needed
}
