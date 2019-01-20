package com.amruta.revolut.fundtransfer.entity;

/**
 * Created by amrutaj on 19/01/2019.
 */
public enum TransactionStatusCode {

    //Using this statusCode you can map the status description to any other language.
    //English is default here.

    SUCCESSFUL("Approved", 0),
    DECLINED_INSUFFICIENT_FUNDS("Declined Insufficient Funds", 1),
    DECLINED_CARD_EXPIRED("Declined Card Expired", 2),
    DECLINED_EXCEEDED_WITHDRAWAL_LIMIT("Declined Exceeds Withdrawal Limit", 3),
    DECLINED_NO_ACCOUNT("Declined No Account", 4),
    DECLINED_ACCOUNT_BLACKLISTED("Declined Fraud Merchant Blacklist", 5);

    private String statusDesc;
    private int statusCode;

    TransactionStatusCode(String statusDesc, int statusCode) {
        this.statusDesc = statusDesc;
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
