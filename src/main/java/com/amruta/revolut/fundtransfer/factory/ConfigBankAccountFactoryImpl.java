package com.amruta.revolut.fundtransfer.factory;

import com.amruta.revolut.fundtransfer.controller.FundTransferController;
import com.amruta.revolut.fundtransfer.repository.AccountRepository;
import com.amruta.revolut.fundtransfer.repository.AccountRepositoryImpl;
import com.amruta.revolut.fundtransfer.repository.TransferStatusRepository;
import com.amruta.revolut.fundtransfer.repository.TransferStatusRepositoryImpl;
import com.amruta.revolut.fundtransfer.service.FundTransferService;
import com.amruta.revolut.fundtransfer.service.FundTransferServiceImpl;

/**
 * Created by amrutaj on 19/01/2019.
 */

/**  This abstarct factory implementation that returns classes required for
 *   performing a bank account transfer.
 */
public class ConfigBankAccountFactoryImpl implements ConfigFactory {

    @Override
    public AccountRepository createAccountRepository() {
        return new AccountRepositoryImpl();
    }

    @Override
    public TransferStatusRepository createFundTransferRepository() {
        return new TransferStatusRepositoryImpl();
    }

    @Override
    public FundTransferService createFundTransferService() {
        return new FundTransferServiceImpl(createAccountRepository(),createFundTransferRepository());
    }

    @Override
    public FundTransferController createFundTransferController() {
        return new FundTransferController(createFundTransferService());
    }
}
