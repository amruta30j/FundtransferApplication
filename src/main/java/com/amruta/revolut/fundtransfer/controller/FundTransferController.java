package com.amruta.revolut.fundtransfer.controller;


import com.amruta.revolut.fundtransfer.entity.TransferStatus;
import com.amruta.revolut.fundtransfer.service.FundTransferService;
import com.amruta.revolut.fundtransfer.util.ResponseUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by amrutaj on 12/01/2019.
 */
// All account APIs can be implemented in this controller
@Path("/account")
public class FundTransferController extends Controller {

    private FundTransferService fundTransferService;

    public FundTransferController(FundTransferService fundTransferService) {
        this.fundTransferService = fundTransferService;
    }

    /** This is a post method to initiate a fund transfer
     *
     * @param fromAc
     * @param toAccount
     * @param ref
     * @param transferAmount
     * @param ref
     * @return transfer status
     */
    @POST
    @Path("/transfer")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String handleFundTransfer(@FormParam("fromAccount") String fromAc,
                                         @FormParam("toAccount") String toAccount,
                                         @FormParam("transferRef") String ref,
                                         @FormParam("transferAmount") String transferAmount) {

        TransferStatus status = fundTransferService.transferFunds(fromAc,toAccount,Double.valueOf(transferAmount),ref);
        return ResponseUtil.generateTransferResponse(status);

    }


    /** This is a Get method to retrive the fund transfer status.
     *
     * @param transactionId
     * @return transfer status
     */

    @GET
    @Path("/transfer/status/{transactionId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public String handleRetrieveTransferDetails(@PathParam("transactionId") String transactionId) {

        TransferStatus status = fundTransferService.getTransactionStatus(Integer.valueOf(transactionId));
        return ResponseUtil.generateTransferResponse(status);
    }


}
