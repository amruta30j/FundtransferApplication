package com.amruta.revolut.fundtransfer.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by amrutaj on 15/01/2019.
 */
public class EntityManagerUtil {
    private static final EntityManagerFactory entityManagerFactory;
    private static final EntityManager entityManager;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("fundtransfer");
            entityManager = entityManagerFactory.createEntityManager();

        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManager getEntityManager() {
        return entityManager;

    }
}
