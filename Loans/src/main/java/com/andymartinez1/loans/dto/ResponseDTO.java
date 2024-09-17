package com.andymartinez1.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold successful response information"
)
public class ResponseDTO {

    @Schema(
            description = "Status code of response"
    )
    private String statusCode;

    @Schema(
            description = "Status message of response"
    )
    private String statusMsg;

}
