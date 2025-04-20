package hiberWeb.web.service;

import hiberWeb.model.Car;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CarService {
    private final List<Car> cars = Arrays.asList(
            new Car(1, "Toyota Camry", 2020),
            new Car(2, "BMW X5", 2021),
            new Car(3, "Audi A4", 2019),
            new Car(4, "Honda Civic", 2022),
            new Car(5, "Mercedes C-Class", 2023)
    );

    public List<Car> getCars(int count) {
        if (count >= 5 || count <= 0) return cars;
        return cars.subList(0, count);
   }
}