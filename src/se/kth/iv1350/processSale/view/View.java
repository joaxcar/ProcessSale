package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.SaleController;
import se.kth.iv1350.processSale.model.SaleDTO;

import java.util.Map;

/**
 * This application does not contain a view. This Class serves as a placeholder for a future view.
 */
public class View {

    private SaleController contr;
    private SaleDTO sale;

    /**
     * Create new instance, set given <code>SaleController</code> as controller
     *
     * @param contr <code>SaleController</code> to use as controller
     */
    public View(SaleController contr) {
        this.contr = contr;
    }

    /**
     * Run a simulated testrun of the application, giving output to the console
     */
    public void testRun(){
        sale = contr.initializeSale();

        System.out.println(sale.getRunningTotal());

        contr.addItemsToSale(1,"0001");
        contr.addItemsToSale(2,"0004");
        contr.addItemsToSale(1,"0002");
        contr.addItemsToSale(4,"0006");

        System.out.println(sale.getRunningTotal());
        System.out.println(sale.lastAddedItem().getName());
        System.out.println(sale.lastAddedItemQuantity());
        System.out.println(sale.getItemCount());
        Map<String, Integer> test = sale.getItemList();

        for (Map.Entry<String, Integer> entry : test.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
;
    }
}
