package com.amruta.revolut.fundtransfer.service;

import com.amruta.revolut.fundtransfer.Exception.InsufficientFundsException;
import com.amruta.revolut.fundtransfer.Exception.InvalidAccountException;
import com.amruta.revolut.fundtransfer.entity.TransactionStatusCode;
import com.amruta.revolut.fundtransfer.entity.TransferStatus;
import com.amruta.revolut.fundtransfer.entity.account.AbstractAccount;
import com.amruta.revolut.fundtransfer.repository.AccountRepository;
import com.amruta.revolut.fundtransfer.repository.TransferStatusRepository;

/**
 * Created by amrutaj on 12/01/2019.
 */
public class FundTransferServiceImpl implements FundTransferService {

    private AccountRepository accountRepository;
    private TransferStatusRepository transferStatusRepository;

    public FundTransferServiceImpl(AccountRepository accountRepository, TransferStatusRepository transferStatusRepository) {

        this.accountRepository = accountRepository;
        this.transferStatusRepository = transferStatusRepository;
    }

    public TransferStatus transferFunds(String fromAccountNum, String toAccountNum, Double transferAmount, String transferRef) {

        TransferStatus status = new TransferStatus();
        status.setFromAccountNum(fromAccountNum);
        status.setToAccountNum(toAccountNum);
        status.setTransferAmount(transferAmount);
        status.setTransferReference(transferRef);
        status.setTransferDate(getTransactionTimeStamp());

        try {
            AbstractAccount fromAccount = accountRepository.findAccountByAccountNum(fromAccountNum);
            AbstractAccount toAccount = accountRepository.findAccountByAccountNum(toAccountNum);

            fromAccount.withdraw(transferAmount);
            toAccount.deposit(transferAmount);

            status.setStatus(TransferStatus.FundTransferStatus.STATUS_SUCCESSFUL.getStatusDescription());
            status.setTransferStausDesc(TransactionStatusCode.SUCCESSFUL.getStatusDesc());
            status.setTransferCode(TransactionStatusCode.SUCCESSFUL.getStatusCode());
        } catch (InsufficientFundsException ex) {
            status.setStatus(TransferStatus.FundTransferStatus.STATUS_FAILED.getStatusDescription());
            status.setTransferStausDesc(TransactionStatusCode.DECLINED_INSUFFICIENT_FUNDS.getStatusDesc());
            status.setTransferCode(TransactionStatusCode.DECLINED_INSUFFICIENT_FUNDS.getStatusCode());
        } catch (InvalidAccountException ex) {
            status.setStatus(TransferStatus.FundTransferStatus.STATUS_FAILED.getStatusDescription());
            status.setTransferStausDesc(TransactionStatusCode.DECLINED_NO_ACCOUNT.getStatusDesc());
            status.setTransferCode(TransactionStatusCode.DECLINED_NO_ACCOUNT.getStatusCode());

        } finally {
            //Transaction must be saved, no matter whether an exception occurs or not.
            transferStatusRepository.saveTransaction(status);
        }
        return status;
    }

    @Override
    public TransferStatus getTransactionStatus(Integer transferId) {
        return transferStatusRepository.getTransactionById(transferId);
    }
}
