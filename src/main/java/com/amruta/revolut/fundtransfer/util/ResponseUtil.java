package com.amruta.revolut.fundtransfer.util;

import com.amruta.revolut.fundtransfer.entity.TransferStatus;

import javax.json.Json;

/**
 * Created by amrutaj on 20/01/2019.
 */
public class ResponseUtil {

    public static String generateTransferResponse(TransferStatus status){

        return Json.createObjectBuilder().
                add(ResponseConstants.TRANSACTION_ID, status.getTransactionId()).
                add(ResponseConstants.FROM_ACCOUNT_NUMBER,status.getFromAccountNum()).
                add(ResponseConstants.TO_ACCOUNT_NUMBER,status.getToAccountNum()).
                add(ResponseConstants.AMOUNT, status.getTransferAmount()).
                add(ResponseConstants.TRANSACTION_STATUS,status.getStatus()).
                add(ResponseConstants.TRANSACTION_STATUS_DESC, status.getTransferStausDesc()).
                add(ResponseConstants.TRANSACTION_STATUS_CODE, status.getTransferCode()).
                add(ResponseConstants.TRANSACTION_DATE, status.getTransferDate()).
                add(ResponseConstants.TRANSACTION_REFERENCE, status.getTransferReference())
                .build().toString();
    }

}
