package com.example.springjdbcdemo;

import com.example.springjdbcdemo.model.Alien;
import com.example.springjdbcdemo.repository.AlienRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbCdemoApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringJdbCdemoApplication.class, args);

        Alien alien = context.getBean(Alien.class);
        alien.setAid(1212);
        alien.setName("Alien");
        alien.setTech("Java");

        AlienRepository alienRepository = context.getBean(AlienRepository.class);
        alienRepository.saveAlien(alien);
        System.out.println(alienRepository.findAll());
    }

}
