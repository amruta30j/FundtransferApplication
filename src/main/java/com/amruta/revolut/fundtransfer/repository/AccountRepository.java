package com.amruta.revolut.fundtransfer.repository;

import com.amruta.revolut.fundtransfer.Exception.InvalidAccountException;
import com.amruta.revolut.fundtransfer.entity.account.AbstractAccount;

import java.util.List;

/**
 * Created by amrutaj on 12/01/2019.
 */
public interface AccountRepository{

    AbstractAccount findAccountByAccountNum(String accountNumber) throws InvalidAccountException;

}
