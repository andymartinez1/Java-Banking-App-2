package com.andymartinez1.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {

    @NotEmpty(message = "Name cannot be empty")
    @Size(min = 5, max = 30, message = "The length of the name should be between 5 and 30 characters")
    private String name;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email address should be a valid email")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{10})", message = "Number must be 10 digits")
    private String mobileNumber;

    private AccountDTO accountDTO;

}
