import hiberWeb.hiber.config.AppConfig;
//import hiber.model.Car;
import hiberWeb.model.User;
import hiberWeb.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

//        Car car1 = new Car("Model S", 1);
//        Car car2 = new Car("Model X", 2);
//        Car car3 = new Car("Mazda", 3);
//        Car car4 = new Car("Toyota", 4);

        User user1 = new User("User1", "Lastname1", "user1@mail.ru");
        User user2 = new User("User2", "Lastname2", "user2@mail.ru");
        User user3 = new User("User3", "Lastname3", "user3@mail.ru");
        User user4 = new User("User4", "Lastname4", "user4@mail.ru");

//        user1.setCar(car1);
//        user2.setCar(car2);
//        user3.setCar(car3);
//        user4.setCar(car4);

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+user.getEmail());

//            if(user.getCar() != null) {
//                System.out.println("Car Model = " + user.getCar().getModel());
//                System.out.println("Car Series = " + user.getCar().getSeries());
//            }

            System.out.println();
        }
//        User carOwner = userService.getUsersCar("Mazda", 3);
//        System.out.println("Владелец машины: " + carOwner.getFirstName());
        context.close();
    }
}
