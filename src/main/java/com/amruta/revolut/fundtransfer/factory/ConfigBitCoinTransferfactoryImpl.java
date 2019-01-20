package com.amruta.revolut.fundtransfer.factory;

import com.amruta.revolut.fundtransfer.controller.FundTransferController;
import com.amruta.revolut.fundtransfer.repository.AccountRepository;
import com.amruta.revolut.fundtransfer.repository.TransferStatusRepository;
import com.amruta.revolut.fundtransfer.service.FundTransferService;

/**
 * Created by amrutaj on 20/01/2019.
 */

/** This implementation is not implemented. It is a skeleton.
 *  However, just to demonstrate that we can even create configuration
 *  to perform a BitcoinAccountsTransferFactory and many more such as
 *  BankCardTypeTransferFactory etc.
 */
public class ConfigBitCoinTransferfactoryImpl implements ConfigFactory {

    @Override
    public AccountRepository createAccountRepository() {
        return null;
    }

    @Override
    public TransferStatusRepository createFundTransferRepository() {
        return null;
    }

    @Override
    public FundTransferService createFundTransferService() {
        return null;
    }

    @Override
    public FundTransferController createFundTransferController() {
        return null;
    }
}
