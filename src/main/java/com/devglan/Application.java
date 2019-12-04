package com.devglan;

import com.devglan.dao.UserDao;
import com.devglan.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner initUser(UserDao userDao, BCryptPasswordEncoder passwordEncoder){
        return args -> {
            userDao.deleteAll();
            User user = new User("amri", passwordEncoder.encode("devglan"), 12345, 34);
            userDao.save(user);
        };
   }

}
