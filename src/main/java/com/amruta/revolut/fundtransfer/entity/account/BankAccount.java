package com.amruta.revolut.fundtransfer.entity.account;

import javax.persistence.*;

/**
 * Created by amrutaj on 12/01/2019.
 */
@Entity
@DiscriminatorValue("BankAccount")
public class BankAccount extends AbstractAccount/*<T extends Number>*/ {

    private String accountType;

    public BankAccount() {

    }

    public BankAccount(String accountNumber, Double accounBalance) {
        super(accountNumber, accounBalance);
    }


    /*public Account(String accountNumber,Double accounBalance) {
        this.accountNumber = accountNumber;
        this.accounBalance = accounBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }*/


}
