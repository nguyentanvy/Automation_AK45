package javastreamperson;

public class Person {
    private String name;
    private int age;
    private String heigh;
    Person(String name, int age, String heigh){
        this.name = name;
        this.age = age;
        this.heigh = heigh;
    };
    public void Show(){
        System.out.println("ten:"+name);
        System.out.println("tuoi"+age);
        System.out.println("Chieu cao "+heigh);
    }
    int getAge(){
        return age;
    };
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", height='" + heigh + "'}";
    }

}
