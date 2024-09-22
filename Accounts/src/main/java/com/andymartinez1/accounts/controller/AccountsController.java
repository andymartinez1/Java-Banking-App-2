package com.andymartinez1.accounts.controller;

import com.andymartinez1.accounts.constants.AccountConstants;
import com.andymartinez1.accounts.dto.AccountContactInfoDTO;
import com.andymartinez1.accounts.dto.CustomerDTO;
import com.andymartinez1.accounts.dto.ErrorResponseDTO;
import com.andymartinez1.accounts.dto.ResponseDTO;
import com.andymartinez1.accounts.service.IAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "CRUD REST APIs for Accounts", description = "Create, Read, Update and Delete Account Details")
@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class AccountsController {

    private final IAccountService iAccountService;

    public AccountsController(IAccountService iAccountService) {
        this.iAccountService = iAccountService;
    }

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private Environment environment;

    @Autowired
    private AccountContactInfoDTO accountContactInfoDTO;

    @Operation(summary = "Create Customer and Account REST API", description = "Create customer account information inside the banking app")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "HTTP Status CREATED"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody CustomerDTO customerDTO) {
        iAccountService.createAccount(customerDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDTO(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @Operation(summary = "Read Customer and Account REST API", description = "Fetch customer account information inside the banking app")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDTO> fetchAccountDetails(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Number must be 10 digits") String mobileNumber) {
        CustomerDTO customerDTO = iAccountService.fetchAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerDTO);
    }

    @Operation(summary = "Update Account REST API", description = "Update customer and account inside the banking app")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "417", description = "Expectation Failed"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateAccountDetails(@Valid @RequestBody CustomerDTO customerDTO) {
        boolean isUpdated = iAccountService.updateAccount(customerDTO);
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountConstants.STATUS_200,
                            AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(AccountConstants.STATUS_417,
                            AccountConstants.MESSAGE_417_UPDATE));
        }
    }

    @Operation(summary = "Delete Account REST API", description = "Delete customer and account inside the banking app")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "417", description = "Expectation Failed"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> deleteAccountDetails(
            @RequestParam @Pattern(regexp = "(^$|[0-9]{10})", message = "Number must be 10 digits") String mobileNumber) {
        boolean isDeleted = iAccountService.deleteAccount(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(AccountConstants.STATUS_200,
                            AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(AccountConstants.STATUS_417,
                            AccountConstants.MESSAGE_417_DELETE));
        }
    }

    @Operation(summary = "Build information", description = "Build information deployed in accounts microservice")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "HTTP Status CREATED"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }

    @Operation(summary = "Java Version", description = "Java version installed in accounts microservice")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "HTTP Status CREATED"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity.status(HttpStatus.OK).body(environment.getProperty("JAVA_HOME"));
    }

    @Operation(summary = "Contact Information", description = "Contact info for accounts microservice")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "HTTP Status CREATED"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error", content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
    })
    @GetMapping("/contact-info")
    public ResponseEntity<AccountContactInfoDTO> getContactInfo() {
        return ResponseEntity.status(HttpStatus.OK).body(accountContactInfoDTO);
    }

}
