package com.amruta.revolut.fundtransfer.repository;

import com.amruta.revolut.fundtransfer.entity.TransferStatus;
import com.amruta.revolut.fundtransfer.util.EntityManagerUtil;

import javax.persistence.EntityManager;

/**
 * Created by amrutaj on 14/01/2019.
 */
public class TransferStatusRepositoryImpl implements TransferStatusRepository {

    private EntityManager entityManager = EntityManagerUtil.getEntityManager();

    @Override
    public TransferStatus saveTransaction(TransferStatus status) {

        entityManager.getTransaction().begin();
        try {
            entityManager.persist(status);
            entityManager.getTransaction().commit();
            return status;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public TransferStatus getTransactionById(Integer transactionId) {
        TransferStatus status = entityManager.find(TransferStatus.class, transactionId);
        return status;
    }
}
