package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.integration.ItemRegistryException;
import se.kth.iv1350.processSale.util.LogHandler;
import se.kth.iv1350.processSale.util.Logger;
import se.kth.iv1350.processSale.integration.NoItemFoundException;
import se.kth.iv1350.processSale.model.ItemDTO;
import se.kth.iv1350.processSale.model.Sale;
import se.kth.iv1350.processSale.model.SaleStateDTO;

/**
 * This class handles requests from view classes concerning sale objects
 */
public class SaleController {
    private ItemRegistry itemReg;
    private Sale currentSale;

    /**
     * Creates new instance of <code>SaleController</code>
     *
     * @param itemReg <code>ItemRegistry</code> to be used by controller
     */
    public SaleController(ItemRegistry itemReg) {
       this.itemReg = itemReg;
    }

    /**
     * Initialize new sale
     */
    public void initializeSale() {
        currentSale = new Sale();
    }

    /**
     * Searches for item in <code>ItemRegistry</code>. Adds found <code>ItemDTO</code> to sale. If no item is found
     * nothing happends
     *
     * @param quantity Quantity of items to be added
     * @param itemID itemID to search for
     * @throws NoItemFoundException when search in item registry fails
     */
    public void addItemsToSale(int quantity, String itemID) throws NoItemFoundException, OperationFailedException {
            try {
                ItemDTO newItem = itemReg.searchItem(itemID);
                currentSale.addItem(newItem, quantity);
            }
            catch (ItemRegistryException ire){
                LogHandler.getLogHandler().logException(ire);
                throw new OperationFailedException("Failed to add item to sale", ire);
            }
    }

    /**
     * End sale, provided <code>PaymentController</code> gets initialized to handel payment of sale
     *
     * @param paymentContr <code>PaymentController</code> to handle payment
     */
    public void endSale(PaymentController paymentContr) {
        paymentContr.initializePayment(currentSale);
        currentSale = null;
    }

    /**
     * Returns sale state as a <code>SaleStateDTO</code>
     *
     * @return sale state from current sale
     */
    public SaleStateDTO getSaleState(){
        return currentSale.getSaleState();
    }
}
