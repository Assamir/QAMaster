package org.qam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"org.qam.service"})
@SpringBootApplication()
public class Main {
  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
    System.out.println("Spring Boot application started!");
  }
}
