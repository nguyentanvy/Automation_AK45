package convertData;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("blue", "1m69"));
        for (Car c : cars) {
            c.printCar();
        }
    }

    }
