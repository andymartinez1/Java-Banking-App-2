package com.andymartinez1.accounts;

import com.andymartinez1.accounts.dto.AccountContactInfoDTO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountContactInfoDTO.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Banking Account Microservices REST API Documentation",
                description = "Banking Account Microservices REST API Documentation",
                version = "v1.0.0"
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
