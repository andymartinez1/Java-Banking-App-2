package com.andymartinez1.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Account",
        description = "Schema for Account Information"
)
public class AccountDTO {

    @Schema(
            description = "Account number", example = "7412589630"
    )
    @NotEmpty(message = "Account number cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Number must be 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "Account type cannot be empty")
    @Schema(
            description = "Type of bank account", example = "Checkings"
    )
    private String accountType;

    @Schema(
            description = "Bank branch address", example = "12 Forest Lane, Oaklahoma, OK"
    )
    @NotEmpty(message = "Branch address cannot be empty")
    private String branchAddress;

}
