package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {
    private static int CARS_COUNT;
    private List<Car> cars;

    public CarDAO() {
        cars = new ArrayList<>();
        cars.add(new Car(++CARS_COUNT, "Model 1", 111, "White"));
        cars.add(new Car(++CARS_COUNT, "Model 2", 222, "Red"));
        cars.add(new Car(++CARS_COUNT, "Model 3", 333, "Blue"));
        cars.add(new Car(++CARS_COUNT, "Model 4", 444, "Black"));
        cars.add(new Car(++CARS_COUNT, "Model 5", 555, "Yellow"));
    }

    public List<Car> getCars() {
        return cars;
    }
}