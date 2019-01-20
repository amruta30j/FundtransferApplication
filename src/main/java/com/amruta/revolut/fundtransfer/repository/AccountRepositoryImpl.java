package com.amruta.revolut.fundtransfer.repository;

import com.amruta.revolut.fundtransfer.Exception.InvalidAccountException;
import com.amruta.revolut.fundtransfer.entity.account.AbstractAccount;
import com.amruta.revolut.fundtransfer.entity.account.BankAccount;
import com.amruta.revolut.fundtransfer.util.EntityManagerUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by amrutaj on 12/01/2019.
 */
public class AccountRepositoryImpl implements AccountRepository {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();


    @Override
    public AbstractAccount findAccountByAccountNum(String accountNumber) throws InvalidAccountException {
        try {
            AbstractAccount account = entityManager.find(AbstractAccount.class, accountNumber);
            return account;
        } catch (Exception e) {
            throw new InvalidAccountException("Invalid Account number");
        }
    }
}
