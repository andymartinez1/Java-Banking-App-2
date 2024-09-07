package com.andymartinez1.accounts.service;

import com.andymartinez1.accounts.dto.CustomerDTO;

public interface IAccountService {

    void createAccount(CustomerDTO customerDTO);

    CustomerDTO fetchAccount(String mobileNumber);

}
