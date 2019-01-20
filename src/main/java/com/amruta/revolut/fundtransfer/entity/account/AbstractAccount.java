package com.amruta.revolut.fundtransfer.entity.account;

import com.amruta.revolut.fundtransfer.Exception.InsufficientFundsException;

import javax.persistence.*;

import static javax.persistence.DiscriminatorType.STRING;

/**
 * Created by amrutaj on 19/01/2019.
 */

@Entity
@Table(name = "Account")
@Inheritance(
        strategy = InheritanceType.SINGLE_TABLE
)
@DiscriminatorColumn(name="Account_Type", discriminatorType=STRING,length=50)
public abstract class AbstractAccount {

    @Id
    @Column(name = "Account_Number")
    protected String accountNumber;

    @Column(name = "Account_Balance")
    protected Double accounBalance;

    public AbstractAccount() {
    }

    public AbstractAccount(String accountNumber, Double accounBalance) {
        this.accountNumber = accountNumber;
        this.accounBalance = accounBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAccounBalance() {
        return accounBalance;
    }

    public void setAccounBalance(Double accounBalance) {
        this.accounBalance = accounBalance;
    }

    public boolean withdraw(Double amount) throws InsufficientFundsException {
        if (this.accounBalance >= amount) {
            this.accounBalance -= amount;
            return Boolean.TRUE;
        }
        throw new InsufficientFundsException("Insufficent funds");
    }

    public boolean deposit(Double amount) {
        this.accounBalance += amount;
        return Boolean.TRUE;
    }
}
