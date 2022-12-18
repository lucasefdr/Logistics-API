package io.github.lucasefdr.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LogisticsApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogisticsApiApplication.class, args);
    }

}
