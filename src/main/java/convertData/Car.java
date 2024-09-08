package convertData;

public class Car {
    private String color;
    private String heigh;
    public Car(String color, String heigh){
        this.color=color;
        this.heigh=heigh;
    }
    String getColor(){
        return color;
    }
    String getHeigh(){
        return heigh;
    }
    void printCar(){
        System.out.println("color:"+getColor()+"heigh: "+getHeigh());
    }
}
