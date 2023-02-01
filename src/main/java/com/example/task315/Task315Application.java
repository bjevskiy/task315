package com.example.task315;

import com.example.task315.model.User;
import com.example.task315.config.Config;
import com.example.task315.consumer.ConsumerWebService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Task315Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ConsumerWebService consumerWebService = context.getBean("consumerWebService", ConsumerWebService.class);
        consumerWebService.getAllUsers();
        consumerWebService.createUser(new User(3L, "James", "Brown", (byte) 40));
        consumerWebService.editUser(new User(3L, "Thomas", "Shelby", (byte) 30));
        consumerWebService.deleteUser(3L);
        System.out.println(ConsumerWebService.result);
    }
}
