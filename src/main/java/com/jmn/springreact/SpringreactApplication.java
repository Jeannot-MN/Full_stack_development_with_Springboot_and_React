package com.jmn.springreact;

import com.jmn.springreact.domain.Car;
import com.jmn.springreact.domain.User;
import com.jmn.springreact.repository.CarRepository;
import com.jmn.springreact.domain.Owner;
import com.jmn.springreact.repository.OwnerRepository;
import com.jmn.springreact.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringreactApplication {

    @Autowired
    CarRepository carRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    UserRepository userRepository;

    private static  final Logger logger = LoggerFactory.getLogger(SpringreactApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringreactApplication.class, args);
        logger.info("Hello spring I'm here for you");
    }
    /*@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:3000")
                        .allowedMethods("GET","POST");
            }
        };
    }*/

    //The CommandLineRunner allow us to execute some additional code just before the App is fully started
    @Bean
    CommandLineRunner runner(){
        return args -> {
            Owner owner1 = new Owner("John", "Johnson");
            Owner owner2 = new Owner("Mary", "Smith");

            ownerRepository.save(owner1);
            ownerRepository.save(owner2);

            carRepository.save(new Car("Ford", "Mustang", "Red",
                    "ADF-1121", 2017, 59000,"THis is a ford", owner1));

            carRepository.save(new Car("Nissan", "Leaf", "White",
                    "SSJ-3002", 2014, 29000, "THis is a Nissan", owner1));

            carRepository.save(new Car("Toyota", "Prius", "Silver",
                    "KKO-0212", 2018, 39000, "THis is a Toyota",owner2));

            // username: user password: user
            userRepository.save(new User("user",
                    "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
                    "USER"));
            // username: admin password: admin
            userRepository.save(new User("admin",
                    "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
                    "ADMIN"));
        };
    }

}
