package cz.uhk.spring2;

import cz.uhk.spring2.model.User;
import cz.uhk.spring2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring2Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring2Application.class, args);
    }

    /*private UserService userService;

    @Autowired
    public Spring2Application(UserService userService) {
        this.userService = userService;
    }

    @Bean
    CommandLineRunner init(UserService userService) {
        return args -> {
          User user = new User();
          user.setUsername("admin");
          user.setPassword("heslo");
          user.setName("Domča Adminů");
          user.setEmail("nereknu@cojetidotoho.com");
          user.setRole("ADMIN");
          userService.saveUser(user);
        };
    }*/

}
