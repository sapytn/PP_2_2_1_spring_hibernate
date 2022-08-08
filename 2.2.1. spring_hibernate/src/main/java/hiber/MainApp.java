package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("tesla",10);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setUserCar(car1);
      userService.add(user1);

      Car car2 = new Car("honda",13);
      User user2 = new User("User1", "Lastname1", "user1@mail.ru");
      user2.setUserCar(car2);
      userService.add(user2);

      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
         System.out.println();
      }

      List<User> carOwnerUser = userService.findCarOwnerUser("tesla",10);
      for (User user : carOwnerUser) {
         System.out.println(user);
         System.out.println();
      }

      context.close();
   }
}
