package com.andymartinez1.loans.service;

import com.andymartinez1.loans.dto.LoanDTO;

public interface ILoanService {

    void createLoan(String mobileNumber);

    LoanDTO fetchLoan(String mobileNumber);

    boolean updateLoan(LoanDTO loanDTO);

    boolean deleteLoan(String mobileNumber);

}
