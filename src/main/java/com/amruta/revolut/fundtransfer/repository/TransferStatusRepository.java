package com.amruta.revolut.fundtransfer.repository;

import com.amruta.revolut.fundtransfer.entity.TransferStatus;

/**
 * Created by amrutaj on 14/01/2019.
 */
public interface TransferStatusRepository {


    TransferStatus saveTransaction(TransferStatus status);

    TransferStatus getTransactionById(Integer transactionId);
}
