package com.amruta.revolut.fundtransfer.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by amrutaj on 13/01/2019.
 */
@Entity
@Table(name = "TransferStatus")
public class TransferStatus implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transactionId;

    @Column(name = "From_Account")
    private String fromAccountNum;

    @Column(name = "To_Account")
    private String toAccountNum;

    @Column(name = "Amount")
    private Double transferAmount;

    @Column(name = "Transfer_Status")
    private String status;

    @Column(name = "Transfer_Fee", nullable = true)
    private Double transferFee;

    @Column(name = "Transfer_description")
    private String transferStausDesc;

    @Column(name = "Transfer_code")
    private int transferCode;

    @Column(name = "Transfer_Date")
    private String transferDate;

    @Column(name = "Transfer_Reference", nullable = true)
    private String transferReference;

    public TransferStatus() {
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public String getFromAccountNum() {
        return fromAccountNum;
    }

    public void setFromAccountNum(String fromAccountNum) {
        this.fromAccountNum = fromAccountNum;
    }

    public String getToAccountNum() {
        return toAccountNum;
    }

    public void setToAccountNum(String toAccountNum) {
        this.toAccountNum = toAccountNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTransferStausDesc() {
        return transferStausDesc;
    }

    public void setTransferStausDesc(String transferStausDesc) {
        this.transferStausDesc = transferStausDesc;
    }

    public int getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(int transferCode) {
        this.transferCode = transferCode;
    }

    public String  getTransferDate() {
        if(Objects.isNull(transferDate)){
            return "";
        }
        return transferDate;
    }

    public void setTransferDate(String transferDate) {
        this.transferDate = transferDate;
    }

    public String getTransferReference() {
        if(Objects.isNull(transferReference)){
            return "";
        }
        return transferReference;
    }

    public void setTransferReference(String transferReference) {
        this.transferReference = transferReference;
    }

    public Double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Double getTransferFee() {
        return transferFee;
    }

    public void setTransferFee(Double transferFee) {
        this.transferFee = transferFee;
    }

    public enum FundTransferStatus {

        STATUS_SUCCESSFUL("successful"),
        STATUS_PENDING("pending"),
        STATUS_FAILED("failed");

        private String statusDescription;


        FundTransferStatus(String description) {
            statusDescription = description;
        }

        public String getStatusDescription() {
            return statusDescription;
        }
    }


}
