package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.controller.OperationFailedException;
import se.kth.iv1350.processSale.controller.PaymentController;
import se.kth.iv1350.processSale.controller.SaleController;
import se.kth.iv1350.processSale.integration.NoItemFoundException;
import se.kth.iv1350.processSale.model.ItemDTO;
import se.kth.iv1350.processSale.model.SaleStateDTO;

/**
 * This application does not contain a view. This Class serves as a placeholder for a future view.
 */
public class View {

    private ErrorMessageHandler errorMsgHandler = new ErrorMessageHandler();
    private SaleController saleContr;
    private PaymentController paymentContr;

    private SaleStateDTO currentSale;

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
        this.paymentContr.addObserver(new TotalRevenueView());
    }

    /**
     * Run a simulated testrun of the application, giving output to the console
     */
    public void testRun(){
        saleContr.initializeSale();


        presentSaleInfo();

        addItems(1,"0001");
        presentSaleInfo();

        addItems(4,"000");
        presentSaleInfo();

        addItems(2,"0004");
        presentSaleInfo();

        addItems(1,"0002");
        presentSaleInfo();

        addItems(4,"0006");
        presentSaleInfo();

        addItems(4,"0000");
        presentSaleInfo();

        try {
            saleContr.endSale(paymentContr);
        }catch (OperationFailedException ex){
            errorMsgHandler.printErrorMessage(ex.getMessage());
        }

        currentSale = paymentContr.getFinalSaleState();
        System.out.println("Total price (inc VAT): " + currentSale.getRunningTotalIncVAT() + "\n");

        paymentContr.makePayment("4000");

        paymentContr.endPayment();

        saleContr.initializeSale();
        presentSaleInfo();

        addItems(1,"0001");
        presentSaleInfo();

        addItems(1,"000");
        presentSaleInfo();

        addItems(2,"0004");
        presentSaleInfo();

        addItems(4,"0002");
        presentSaleInfo();

        try {
            saleContr.addDiscount();
        }catch (OperationFailedException ex){
            errorMsgHandler.printErrorMessage(ex.getMessage());
        }
        try {
            saleContr.endSale(paymentContr);
        }catch (OperationFailedException ex){
            errorMsgHandler.printErrorMessage(ex.getMessage());
        }

        currentSale = paymentContr.getFinalSaleState();
        System.out.println("Total price (inc VAT): " + currentSale.getRunningTotalIncVAT() + "\n");


        paymentContr.makePayment("23000");

        paymentContr.endPayment();
    }

    /*
     * Try to add an item to sale
     */
    private void addItems(int quantity, String itemID){
        try{
            saleContr.addItemsToSale(quantity,itemID);
        }
        catch (NoItemFoundException ex){
            errorMsgHandler.printErrorMessage("No item with ID " + ex.getSearchedItemID());
        }
        catch (OperationFailedException ex){
            errorMsgHandler.printErrorMessage(ex.getMessage());
        }

    }

    /*
     * Retrieves and prints sale info to terminal
     */
    private void presentSaleInfo(){
        try{
            currentSale = saleContr.getSaleState();
        } catch (OperationFailedException ex){
            errorMsgHandler.printErrorMessage(ex.getMessage());
        }
        ItemDTO lastAddedItem = currentSale.getLastAddedItem();
        System.out.println("Running total (inc VAT): " + currentSale.getRunningTotalIncVAT());
        System.out.println("Last added item name: " + lastAddedItem.getName());
        System.out.println("Last added item price: " + lastAddedItem.getPriceIncVAT());
        System.out.println("-------------------");
    }
}
