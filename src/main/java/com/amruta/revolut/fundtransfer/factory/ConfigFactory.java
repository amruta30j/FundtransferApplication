package com.amruta.revolut.fundtransfer.factory;

import com.amruta.revolut.fundtransfer.controller.FundTransferController;
import com.amruta.revolut.fundtransfer.repository.AccountRepository;
import com.amruta.revolut.fundtransfer.repository.TransferStatusRepository;
import com.amruta.revolut.fundtransfer.service.FundTransferService;

/**
 * Created by amrutaj on 19/01/2019.
 */
// Generate configuration for application
// Returns set of classes for injection that generate a functioning application
public interface ConfigFactory {


    AccountRepository createAccountRepository();

    TransferStatusRepository  createFundTransferRepository();

    FundTransferService createFundTransferService();

    FundTransferController createFundTransferController();


}
