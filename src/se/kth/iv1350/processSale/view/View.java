package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.PosController;
import se.kth.iv1350.processSale.model.SaleDTO;
import se.kth.iv1350.processSale.model.SaleStateDTO;

public class View {

    private PosController contr;
    private SaleStateDTO saleState;
    private SaleDTO sale;

    public View(PosController contr) {
        this.contr = contr;
    }

    public void testRun(){
        sale = contr.initializeSale();
        System.out.println(sale.getRunningTotal());
        contr.addItemsToSale(1,"0001");
        contr.addItemsToSale(2,"0004");
        contr.addItemsToSale(1,"0002");
        contr.addItemsToSale(4,"0006");
        System.out.println(sale.getRunningTotal());
    }
}
