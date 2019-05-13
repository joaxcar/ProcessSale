package se.kth.iv1350.processSale.startup;

import se.kth.iv1350.processSale.controller.PaymentController;
import se.kth.iv1350.processSale.controller.SaleController;
import se.kth.iv1350.processSale.integration.*;
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
        AccountingSystem accountingSys = new AccountingSystem();
        CashRegister cashRegister = new CashRegister("Register 1");
        ItemRegistry itemReg = new ItemRegistry();

        ExternalSystems extSys = new ExternalSystems(itemReg, accountingSys);
        SaleController saleContr = new SaleController (itemReg);
        PaymentController paymentContr = new PaymentController(cashRegister, extSys);
        View view = new View(saleContr, paymentContr);
        view.testRun();
    }

}
