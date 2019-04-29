package se.kth.iv1350.processSale.startup;

import se.kth.iv1350.processSale.controller.SaleController;
import se.kth.iv1350.processSale.integration.AccountingSystem;
import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.integration.Log;
import se.kth.iv1350.processSale.model.CashRegister;
import se.kth.iv1350.processSale.view.View;

/**
 * Contains the <code>main</code> method. Responsible for getting the application started
 */
public class ProcessSale {

    /**
     * Starts the application
     *
     * @param args The application does not take any arguments
     */
    public static void main(String[] args) {
        SaleController contr;
        ItemRegistry itemReg;
        AccountingSystem accountingSys;
        CashRegister cashRegister;
        Log log;
        View view;

        itemReg = new ItemRegistry();
        log = new Log();
        cashRegister = new CashRegister();
        accountingSys = new AccountingSystem();
        contr = new SaleController(cashRegister, itemReg, log, accountingSys);
        view = new View(contr);
        view.testRun();
    }

}
