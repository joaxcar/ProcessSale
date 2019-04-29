package se.kth.iv1350.processSale.startup;

import se.kth.iv1350.processSale.controller.SaleController;
import se.kth.iv1350.processSale.integration.CustomerRegistry;
import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.integration.Log;
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
        View view;

        Log log;
        CustomerRegistry customerRegistry;

        itemReg = new ItemRegistry();
        contr = new SaleController(itemReg);
        view = new View(contr);

        view.testRun();
    }

}
