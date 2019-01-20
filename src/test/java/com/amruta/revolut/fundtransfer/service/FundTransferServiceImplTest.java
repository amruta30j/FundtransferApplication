package com.amruta.revolut.fundtransfer.service;

import com.amruta.revolut.fundtransfer.Exception.InvalidAccountException;
import com.amruta.revolut.fundtransfer.entity.TransactionStatusCode;
import com.amruta.revolut.fundtransfer.entity.TransferStatus;
import com.amruta.revolut.fundtransfer.entity.account.AbstractAccount;
import com.amruta.revolut.fundtransfer.entity.account.BankAccount;
import com.amruta.revolut.fundtransfer.repository.AccountRepository;
import com.amruta.revolut.fundtransfer.repository.TransferStatusRepository;
import com.amruta.revolut.fundtransfer.util.ResponseUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by amrutaj on 20/01/2019.
 */
@RunWith(MockitoJUnitRunner.Silent.class)
class FundTransferServiceImplTest {


    private AbstractAccount fromAccount;
    private AbstractAccount toAccount;
    private TransferStatus transferStatus_successful;

    @Mock
    private AccountRepository accountRepositoryMock;

    @Mock
    private TransferStatusRepository transferStatusRepositoryMock;

    @InjectMocks
    private FundTransferService fundTransferService = new FundTransferServiceImpl(accountRepositoryMock, transferStatusRepositoryMock);






    @Before
    public void setUp(){

        fromAccount = new BankAccount("fromAccount_XXX", 500.0);
        toAccount = new BankAccount("toAccount_XXX",300.0);


        transferStatus_successful = new TransferStatus();
        transferStatus_successful.setTransactionId(1);
        transferStatus_successful.setFromAccountNum("fromAccount_XXX");
        transferStatus_successful.setToAccountNum("toAccount_XXX");
        transferStatus_successful.setTransferAmount(100.0);
        transferStatus_successful.setStatus(TransferStatus.FundTransferStatus.STATUS_SUCCESSFUL.getStatusDescription());
        transferStatus_successful.setTransferStausDesc(TransactionStatusCode.SUCCESSFUL.getStatusDesc());
        transferStatus_successful.setTransferCode(TransactionStatusCode.SUCCESSFUL.getStatusCode());

    }


    @Test
    public void transferFunds(){

        try {
            Mockito.when(accountRepositoryMock.findAccountByAccountNum("fromAccount_XXX")).thenReturn(fromAccount);
            Mockito.when(accountRepositoryMock.findAccountByAccountNum("toAccount_XXX")).thenReturn(toAccount);
            Mockito.when(transferStatusRepositoryMock.saveTransaction(transferStatus_successful)).thenReturn(transferStatus_successful);
            fundTransferService.transferFunds("fromAccount_XXX", "toAccount_XXX", 100.0, "testRef");
            Assert.assertNotNull(ResponseUtil.generateTransferResponse(transferStatus_successful));
        } catch (InvalidAccountException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getTransactionStatus() {

    }

    @After
    public void tearDown(){

    }

}