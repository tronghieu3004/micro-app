package dev.omega.microshopapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableWebSecurity
@EnableJpaAuditing
public class MicroShopAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroShopAppApplication.class, args);
    }

}
