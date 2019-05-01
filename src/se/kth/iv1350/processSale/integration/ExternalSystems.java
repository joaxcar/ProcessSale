package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.ReceiptDTO;
import se.kth.iv1350.processSale.model.Sale;

public class ExternalSystems {


    private final ItemRegistry itemReg;
    private final AccountingSystem accountingSys;
    private final Log log;

    public ExternalSystems(ItemRegistry itemReg, AccountingSystem accountingSys, Log log) {
        this.itemReg = itemReg;
        this.accountingSys = accountingSys;
        this.log = log;
    }

    public void makeEntry(Sale sale, ReceiptDTO reciept) {
        writeAccountingSystem(reciept);
        writeToLog(sale);
        updateItemRegistry(sale);
    }

    private void writeAccountingSystem(ReceiptDTO reciept) {
        accountingSys.makeEntry(reciept);
    }

    private void writeToLog(Sale sale){
        log.logEntry(sale);
    }

    private void updateItemRegistry(Sale sale){
        itemReg.updateInventory(sale);
    }
}
