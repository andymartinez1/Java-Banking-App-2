package com.andymartinez1.cards;

import com.andymartinez1.cards.dto.CardContactInfoDTO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {CardContactInfoDTO.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Banking Cards Microservices REST API Documentation",
                description = "Banking Cards Microservices REST API Documentation",
                version = "v1.0.0"
        )
)
public class CardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardsApplication.class, args);
    }

}
