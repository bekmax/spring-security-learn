package com.springsecuritylearn;

import com.springsecuritylearn.domain.Role;
import com.springsecuritylearn.domain.User;
import com.springsecuritylearn.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityLearnApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService){
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Johny Depp", "depp", "123", new ArrayList<>()));
            userService.saveUser(new User(null, "Will Smith", "smith", "123", new ArrayList<>()));
            userService.saveUser(new User(null, "Bradley Cooper", "cooper", "123", new ArrayList<>()));
            userService.saveUser(new User(null, "Ryan Reynolds", "reynolds", "123", new ArrayList<>()));
            userService.saveUser(new User(null, "Tom Hanks", "hanks", "123", new ArrayList<>()));
            userService.saveUser(new User(null, "Tom Holland", "holland", "123", new ArrayList<>()));

            userService.addRoleToUser("depp", "ROLE_USER");
            userService.addRoleToUser("smith", "ROLE_MANAGER");
            userService.addRoleToUser("cooper", "ROLE_MANAGER");
            userService.addRoleToUser("reynolds", "ROLE_USER");
            userService.addRoleToUser("hanks", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("depp", "ROLE_ADMIN");
        };
    }

}
