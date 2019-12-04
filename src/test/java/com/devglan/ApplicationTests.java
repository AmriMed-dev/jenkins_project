package com.devglan;

import com.devglan.dao.UserDao;
import com.devglan.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApplicationTests {

   
    
    @Test
	public void contextLoads() {
	}
    
//    @Bean
//    CommandLineRunner initUser(UserDao userDao, BCryptPasswordEncoder passwordEncoder){
//        return args -> {
//            userDao.deleteAll();
//            User user = new User(12345);
//            userDao.save(user);
//        };
//    }

}
