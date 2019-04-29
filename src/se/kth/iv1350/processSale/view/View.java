package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.SaleController;
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

        System.out.println(sale.getRunningTotal());

        contr.addItemsToSale(1,"0001");
        contr.addItemsToSale(2,"0004");
        contr.addItemsToSale(1,"0002");
        contr.addItemsToSale(4,"0006");

        System.out.println(sale.getRunningTotal());
        System.out.println(sale.getLastAddedItem().getName());
        System.out.println(sale.getItemCount());
        List<GroupedItem> test = sale.getItemList();

        for (GroupedItem item : test) {
            System.out.println(item.getName() + " : " + item.getQuantity());
        }
;
    }
}
