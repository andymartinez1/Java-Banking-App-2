package com.andymartinez1.loans.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "loans")
public record LoanContactInfoDTO(String message,
                                 Map<String, String> contactDetails,
                                 List<String> onCallSupport) {
}
