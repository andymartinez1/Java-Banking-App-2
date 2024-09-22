package com.andymartinez1.loans;

import com.andymartinez1.loans.dto.LoanContactInfoDTO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {LoanContactInfoDTO.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Banking Loans Microservices REST API Documentation",
                description = "Banking Loans Microservices REST API Documentation",
                version = "v1.0.0"
        )
)
public class LoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class, args);
    }

}
