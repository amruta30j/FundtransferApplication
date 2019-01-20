package com.amruta.revolut.fundtransfer.service;

import com.amruta.revolut.fundtransfer.entity.TransferStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by amrutaj on 12/01/2019.
 */
public interface FundTransferService {

    TransferStatus transferFunds(String fromAccountNum, String toAccountNum, Double transferAmount, String transferRef);

    TransferStatus getTransactionStatus(Integer transferId);

    default String getTransactionTimeStamp(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
