package com.andymartinez1.cards.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "ErrorResonse",
        description = "Schema to hold error response information"
)
public class ErrorResponseDTO {

    @Schema(
            description = "API path invoked by client"
    )
    private String apiPath;

    @Schema(
            description = "Error code of error that occurred"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message of occurred error"
    )
    private String errorMessage;

    @Schema(
            description = "Date and time of error"
    )
    private LocalDateTime errorTime;

}
