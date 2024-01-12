package com.danilo.project.paymentmanagementservice.config;

import com.danilo.project.paymentmanagementservice.entities.User;
import com.danilo.project.paymentmanagementservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null,"Mordecai","99999999");
        User u2 = new User(null,"Rigby","8888888888");

        userRepository.saveAll(Arrays.asList(u1,u2));



    }
}
