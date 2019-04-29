package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.SaleController;
import se.kth.iv1350.processSale.model.Amount;
import se.kth.iv1350.processSale.model.GroupedItem;
import se.kth.iv1350.processSale.model.SaleDTO;

import java.util.List;
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

        contr.addItemsToSale(1,"0001");
        presentRunningTotal();
        presentItemList();
        System.out.println("\n------------------- \n");
        contr.addItemsToSale(2,"0004");
        presentRunningTotal();
        presentItemList();
        System.out.println("\n------------------- \n");
        contr.addItemsToSale(1,"0002");
        presentRunningTotal();
        presentItemList();
        System.out.println("\n------------------- \n");
        contr.addItemsToSale(4,"0006");
        presentRunningTotal();
        presentItemList();
        System.out.println("\n------------------- \n");

        System.out.println(sale.getLastAddedItem().getName());
        System.out.println(sale.getItemCount());
;
    }
    private void presentItemList(){
        List<GroupedItem> items = sale.getItemList();

        for (GroupedItem item : items) {
            System.out.println(item.getName() + " : " + item.getQuantity());
        }
    }
    private void presentRunningTotal(){
        Amount runningTotal = sale.getRunningTotal();
        runningTotal.addAmount(sale.getVAT());
        System.out.println("Running total (inc VAT): " + runningTotal);
    }
}
