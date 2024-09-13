package com.andymartinez1.cards.service;

import com.andymartinez1.cards.dto.CardDTO;

public interface ICardService {

    void createCard(String mobileNumber);

    CardDTO fetchCard(String mobileNumber);

    boolean updateCard(CardDTO cardDTO);

    boolean deleteCard(String mobileNumber);

}
