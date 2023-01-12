package br.com.Attornatus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan; 

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication
@EntityScan(basePackages = {"br.com.Attornatus.model"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
