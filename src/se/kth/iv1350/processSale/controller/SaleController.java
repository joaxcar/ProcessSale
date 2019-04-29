package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.AccountingSystem;
import se.kth.iv1350.processSale.integration.ItemDTO;
import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.integration.Log;
import se.kth.iv1350.processSale.model.*;

public class SaleController {

    private Sale currentSale;

    private Payment currentPayment;
    private AccountingSystem accountingSys;
    private CashRegister cashRegister;
    private ItemRegistry itemReg;
    private Log log;

    public SaleController(CashRegister cashRegister, ItemRegistry itemReg, Log log, AccountingSystem accountingSys) {
       this.cashRegister = cashRegister;
       this.itemReg = itemReg;
       this.accountingSys = accountingSys;
       this.log = log;
    }

    public SaleDTO initializeSale() {
        currentSale = new Sale();
        return currentSale;
    }

    public void addItemsToSale(int quantity, String itemID) {
        ItemDTO newItem = itemReg.searchItem(itemID);

        if (newItem != null) {
            for (int i = 0; i < quantity; i++) {
                currentSale.addItem(newItem);
            }
        }

    }


    public SaleDTO endSale() {
        currentPayment = new Payment(currentSale, cashRegister, log);
        currentSale = null;
        return currentPayment.getSale();
    }

    public Amount pay(Amount paidAmt) {
        currentPayment.makePayment(paidAmt);
        Amount change = currentPayment.getChange();

        if (currentPayment.checkPaymentDone()){
            currentPayment.endPayment();
            accountingSys.makeEntry(currentPayment);
            for (GroupedItem item : currentPayment.getSale().getItemList()){
                itemReg.updateInventory(item.getAsList());
            }
            currentPayment = null;
        }

        return change;
    }

}
