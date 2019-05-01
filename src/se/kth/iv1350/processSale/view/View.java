package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.PaymentController;
import se.kth.iv1350.processSale.controller.SaleController;
import se.kth.iv1350.processSale.model.ItemDTO;
import se.kth.iv1350.processSale.model.SaleStateDTO;

/**
 * This application does not contain a view. This Class serves as a placeholder for a future view.
 */
public class View {

    private SaleController saleContr;
    private PaymentController paymentContr;

    SaleStateDTO currentSale;

    /**
     * Create new instance, set given <code>SaleController</code> as sale controller
     * and givem <code>PaymentController</code> as payment controller
     *
     * @param saleContr <code>SaleController</code> for sale
     * @param paymentContr <code>PaymentController</code> for payment
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
        currentSale = saleContr.getSaleState();

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

        currentSale = paymentContr.getFinalSaleState();
        System.out.println("Total price (inc VAT): " + currentSale.getRunningTotalIncVAT() + "\n");

        paymentContr.makePayment("4000");

        paymentContr.endPayment();
    }

    /*
     * Retrieves and prints sale info to terminal
     */
    private void presentSaleInfo(){
        currentSale = saleContr.getSaleState();
        ItemDTO lastAddedItem = currentSale.getLastAddedItem();
        System.out.println("Running total (inc VAT): " + currentSale.getRunningTotalIncVAT());
        System.out.println("Last added item name: " + lastAddedItem.getName());
        System.out.println("Last added item price: " + lastAddedItem.getPriceIncVAT());
        System.out.println("-------------------");
    }
}
