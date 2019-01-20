package com.amruta.revolut.fundtransfer.entity.account;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by amrutaj on 19/01/2019.
 */
/*This class extends an AbstractAccount.
We can implement a factory method design pattern  so that user can decide which type of Account he/she wants to create*/

@Entity
@DiscriminatorValue("CertificateOfDepositAccount")
public class CertificateOfDepositAccount extends AbstractAccount {

    public CertificateOfDepositAccount() {
    }
}
