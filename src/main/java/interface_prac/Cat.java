package interface_prac;

public class Cat implements Animal {
    public Cat(){
    }

    @Override
    public void Sound() {
        System.out.println("Meo meoo");

    }

    @Override
    public void Action() {
        System.out.println("Eat fish");
    }
}
