package com.jmn.springreact;

import com.jmn.springreact.domain.Car;
import com.jmn.springreact.domain.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringreactApplication {

    @Autowired
    CarRepository carRepository;

    private static  final Logger logger = LoggerFactory.getLogger(SpringreactApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringreactApplication.class, args);
        logger.info("Hello spring I'm here for you");
    }

    @Bean
    CommandLineRunner runner(){
        return args -> {
            carRepository.save(new Car("Ford", "Mustang", "Red",
                    "ADF-1121", 2017, 59000,"THis is a ford"));

            carRepository.save(new Car("Nissan", "Leaf", "White",
                    "SSJ-3002", 2014, 29000, "THis is a Nissan"));

            carRepository.save(new Car("Toyota", "Prius", "Silver",
                    "KKO-0212", 2018, 39000, "THis is a Toyota"));
        };
    }

}
