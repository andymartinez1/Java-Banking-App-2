package com.andymartinez1.loans.mapper;

import com.andymartinez1.loans.dto.LoanDTO;
import com.andymartinez1.loans.entity.Loan;

public class LoanMapper {

    public static LoanDTO mapToLoanDTO(Loan loan, LoanDTO loanDTO) {
        loanDTO.setLoanNumber(loan.getLoanNumber());
        loanDTO.setLoanType(loan.getLoanType());
        loanDTO.setMobileNumber(loan.getMobileNumber());
        loanDTO.setTotalLoan(loan.getTotalLoan());
        loanDTO.setAmountPaid(loan.getAmountPaid());
        loanDTO.setOutstandingAmount(loan.getOutstandingAmount());
        return loanDTO;
    }

    public static Loan mapToLoan(LoanDTO loanDTO, Loan loan) {
        loan.setLoanNumber(loanDTO.getLoanNumber());
        loan.setLoanType(loanDTO.getLoanType());
        loan.setMobileNumber(loanDTO.getMobileNumber());
        loan.setTotalLoan(loanDTO.getTotalLoan());
        loan.setAmountPaid(loanDTO.getAmountPaid());
        loan.setOutstandingAmount(loanDTO.getOutstandingAmount());
        return loan;
    }

}
