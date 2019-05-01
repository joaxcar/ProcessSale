package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.ReceiptDTO;

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
