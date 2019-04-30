package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.PaymentController;
import se.kth.iv1350.processSale.controller.SaleController;
import se.kth.iv1350.processSale.model.ItemDTO;
import se.kth.iv1350.processSale.model.SaleDTO;

import java.util.List;

/**
 * This application does not contain a view. This Class serves as a placeholder for a future view.
 */
public class View {

    private SaleController saleContr;
    private PaymentController paymentContr;
    private SaleDTO sale;

    /**
     * Create new instance, set given <code>SaleController</code> as controller
     *
     * @param saleContr <code>SaleController</code> to use as controller
     * @param paymentContr
     */
    public View(SaleController saleContr, PaymentController paymentContr) {
        this.saleContr = saleContr;
        this.paymentContr = paymentContr;
    }

    /**
     * Run a simulated testrun of the application, giving output to the console
     */
    public void testRun(){
        saleContr.initializeSale();
        presentSaleInfo();

        saleContr.addItemsToSale(1,"0001");
        presentSaleInfo();

        saleContr.addItemsToSale(2,"0004");
        presentSaleInfo();

        saleContr.addItemsToSale(1,"0002");
        presentSaleInfo();

        saleContr.addItemsToSale(4,"0006");
        presentSaleInfo();


        saleContr.endSale(paymentContr);
        System.out.println("End of sale \nList of items:\n");
        System.out.println("Total price (inc VAT): " + paymentContr.getTotalPriceIncVAT() + "\n");


        //System.out.println("\nChange: " + change);

    }
    private void presentItemList(){
        List<ItemDTO> items = sale.getItemList();

        for (ItemDTO item : items) {
            System.out.println(item.getName() + " : " + item.getQuantity());
        }
    }
    private void presentSaleInfo(){
        ItemDTO lastAddedItem = saleContr.getLastAddedItem();
        System.out.println("-------------------");
        System.out.println("Running total (inc VAT): " + saleContr.getRunningTotalIncVAT());
        System.out.println("Last added item name: " + lastAddedItem.getName());
        System.out.println("Last added item price: " + lastAddedItem.getPriceIncVAT());
        System.out.println("-------------------\n");
    }
}
