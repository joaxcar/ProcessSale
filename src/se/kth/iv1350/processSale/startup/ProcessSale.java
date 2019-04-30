package se.kth.iv1350.processSale.startup;

import se.kth.iv1350.processSale.controller.PaymentController;
import se.kth.iv1350.processSale.controller.SaleController;
import se.kth.iv1350.processSale.integration.AccountingSystem;
import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.integration.Log;
import se.kth.iv1350.processSale.integration.Printer;
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
        SaleController saleContr;
        PaymentController paymentContr;
        ItemRegistry itemReg;
        AccountingSystem accountingSys;
        CashRegister cashRegister;
        Log log;
        View view;
        Printer printer;

        itemReg = new ItemRegistry();
        log = new Log();
        cashRegister = new CashRegister("Register 1");
        accountingSys = new AccountingSystem();
        printer = new Printer();
        saleContr = new SaleController (itemReg);
        paymentContr = new PaymentController(accountingSys, cashRegister, log, itemReg, printer);
        view = new View(saleContr, paymentContr);

        view.testRun();
    }

}
