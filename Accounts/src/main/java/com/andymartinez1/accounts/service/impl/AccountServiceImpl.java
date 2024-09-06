package com.andymartinez1.accounts.service.impl;

import com.andymartinez1.accounts.dto.CustomerDTO;
import com.andymartinez1.accounts.repository.AccountsRepository;
import com.andymartinez1.accounts.repository.CustomerRepository;
import com.andymartinez1.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDTO customerDTO) {

    }
}
