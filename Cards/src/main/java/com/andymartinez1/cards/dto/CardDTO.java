package com.andymartinez1.cards.dto;

import lombok.Data;

@Data
public class CardDTO {

    private String mobileNumber;

    private String cardNumber;

    private String cardType;

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;

}
