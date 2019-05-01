package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.ReceiptDTO;

/**
 * This class works as a placeholder for a real integration to an external accounting system
 */
public class AccountingSystem {
    public AccountingSystem(){}

    /**
     * Make entry in accounting system
     *
     * @param receipt <code>ReceiptDTO</code> to translate to entry
     */
    public void makeEntry(ReceiptDTO receipt){
        System.out.println("Updating accounting system with receipt from register:" + receipt.getRegisterID());
    }
}
