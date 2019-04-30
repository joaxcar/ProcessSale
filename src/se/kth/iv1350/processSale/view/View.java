package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.SaleController;
import se.kth.iv1350.processSale.integration.ItemDTO;
import se.kth.iv1350.processSale.model.Amount;
import se.kth.iv1350.processSale.model.SaleDTO;

import java.util.List;

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
        presentSaleInfo();

        contr.addItemsToSale(1,"0001");
        presentSaleInfo();

        contr.addItemsToSale(2,"0004");
        presentSaleInfo();

        contr.addItemsToSale(1,"0002");
        presentSaleInfo();

        contr.addItemsToSale(4,"0006");
        presentSaleInfo();


        sale = contr.endSale();
        System.out.println("End of sale \nList of items:\n");
        presentItemList();
        System.out.println("Total price (inc VAT): " + sale.getRunningTotalIncVAT() + "\n");


        Amount change = contr.pay(new Amount(4000));
        System.out.println("\nChange: " + change);

    }
    private void presentItemList(){
        List<ItemDTO> items = sale.getItemList();

        for (ItemDTO item : items) {
            System.out.println(item.getName() + " : " + item.getQuantity());
        }
    }
    private void presentSaleInfo(){
        System.out.println("-------------------");
        Amount runningTotalIncVAT = sale.getRunningTotalIncVAT();
        ItemDTO lastAddedItem = sale.getLastAddedItem();
        int quantity = lastAddedItem.getQuantity();
        System.out.println("Running total (inc VAT): " + runningTotalIncVAT);
        System.out.println("Last added item name: " + lastAddedItem.getName());
        System.out.println("Last added item price: " + lastAddedItem.getPriceIncVAT());
        System.out.println("Last added item quantity: " + quantity);
        System.out.println("-------------------\n");
    }
}
