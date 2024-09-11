package com.andymartinez1.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema for Customer and Account Details"
)
public class CustomerDTO {

    @Schema(
            description = "Name of the customer", example = "Test User"
    )
    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 5, max = 30, message = "The length of the name should be between 5 and 30 characters")
    private String name;

    @Schema(
            description = "Customer email", example = "Test@test.com"
    )
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email address should be a valid email")
    private String email;

    @Schema(
            description = "Customer mobile number", example = "9876543210"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Number must be 10 digits")
    private String mobileNumber;

    private AccountDTO accountDTO;

}
