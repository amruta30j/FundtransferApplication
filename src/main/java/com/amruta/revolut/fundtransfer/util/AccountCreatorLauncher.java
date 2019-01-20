package com.amruta.revolut.fundtransfer.util;

import com.amruta.revolut.fundtransfer.entity.account.AbstractAccount;
import com.amruta.revolut.fundtransfer.entity.account.BankAccount;

import javax.persistence.EntityManager;

/**
 * Created by amrutaj on 16/01/2019.
 */
public class AccountCreatorLauncher {

    private static EntityManager entityManager = EntityManagerUtil.getEntityManager();

    public static AbstractAccount createAccount(String accNumber, Double accBal, String accType) throws Exception {
        entityManager.getTransaction().begin();
        AbstractAccount account = new BankAccount(accNumber,accBal);
        try {
            entityManager.persist(account);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return account;
    }

}
