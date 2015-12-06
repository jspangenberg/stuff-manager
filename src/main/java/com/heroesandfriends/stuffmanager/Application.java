package com.heroesandfriends.stuffmanager;

import com.heroesandfriends.stuffmanager.service.StuffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author John Spangenberg
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    StuffService stuffService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
