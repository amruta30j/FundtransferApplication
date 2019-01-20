package com.amruta.revolut.fundtransfer;

import com.amruta.revolut.fundtransfer.entity.account.AbstractAccount;
import com.amruta.revolut.fundtransfer.factory.ConfigBankAccountFactoryImpl;
import com.amruta.revolut.fundtransfer.factory.ConfigFactory;
import com.amruta.revolut.fundtransfer.util.AccountCreatorLauncher;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;


/**
 * Created by amrutaj on 12/01/2019.
 */
public class Application {

    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.addServlet(new ServletHolder(new ServletContainer(getController(new ConfigBankAccountFactoryImpl()))), "/*");

        Server jettyServer = new Server(8085);
        jettyServer.setHandler(context);

        //Creating accounts initially with some balance.
        // As the functionality is about transferring the funds
        //rather than creating the accounts. There is no API provided to create, authenticate, authorize etc.
        //those use cases must be implemented separately

        AbstractAccount fromAccount = AccountCreatorLauncher.createAccount("fromAccount_XXX", 20.0,"Bank account");
        AbstractAccount toAccount = AccountCreatorLauncher.createAccount("toAccount_XXX", 300.0, "Bank account");

        // Start server
        try {
            jettyServer.start();
        } catch (Exception e) {
            jettyServer.stop();
        }

    }

    /** This function returning the ResourceConfig settings for transfer functionality.
     * This is taking the Config factory as an input and the user can invoke the any
     * config factory implementation avavliable . ex BankAccountTransferFactoryconfig
     * or BitCoinFactortConfig or CreditCardTransferFacotyConfig etc.
     * @param factory
     * @return
     */
    private static ResourceConfig getController(ConfigFactory factory) {
        return new ResourceConfig().register(factory.createFundTransferController());
    }
}
