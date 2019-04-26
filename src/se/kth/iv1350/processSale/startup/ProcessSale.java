package se.kth.iv1350.processSale.startup;

import se.kth.iv1350.processSale.controller.PosController;
import se.kth.iv1350.processSale.integration.CustomerRegistry;
import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.integration.Log;
import se.kth.iv1350.processSale.view.View;

public class ProcessSale {



    public static void main(String[] args) {
        PosController contr;
        ItemRegistry itemReg;
        View view;

        Log log;
        CustomerRegistry customerRegistry;

        itemReg = new ItemRegistry();
        contr = new PosController(itemReg);
        view = new View(contr);

        view.testRun();
    }

}
