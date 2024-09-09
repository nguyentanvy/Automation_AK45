package annotations;

import org.testng.annotations.Factory;

public class TestExecuteFactory {
    @Factory
    public Object[] factoryMethod(){
        return new Object[]{
                new TestFactory(1),
                new TestFactory(2),
                new TestFactory(3)
        };
    }
}
