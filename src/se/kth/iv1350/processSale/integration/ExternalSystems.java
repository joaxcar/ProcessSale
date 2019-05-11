package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.ReceiptDTO;
import se.kth.iv1350.processSale.model.Sale;


/**
 * This class handles interaction with external systems such as the accounting system, log and the item registry
 */
public class ExternalSystems {

    private final ItemRegistry itemReg;
    private final AccountingSystem accountingSys;

    /**
     * Creates new instance of <code>ExternalSystems</code>
     * @param itemReg <code>ItemRegistry</code> to connect to
     * @param accountingSys <code>AccountingSystem</code> to connect to
     */
    public ExternalSystems(ItemRegistry itemReg, AccountingSystem accountingSys) {
        this.itemReg = itemReg;
        this.accountingSys = accountingSys;
    }

    /**
     * Passes the arguments to the relevant external system to make entries
     * @param sale <code>Sale</code> to log and pass to <code>ItemRegistry</code>
     * @param reciept <code>Receipt</code> to pass to <code>AccountingSystem</code>
     */
    public void makeEntry(Sale sale, ReceiptDTO reciept) {
        writeAccountingSystem(reciept);
        updateItemRegistry(sale);
    }

    // Helper functions for passing arguments

    private void writeAccountingSystem(ReceiptDTO reciept) {
        accountingSys.makeEntry(reciept);
    }

    private void updateItemRegistry(Sale sale){
        itemReg.subtractFromInventory(sale.getGroupedItemList());
    }
}
