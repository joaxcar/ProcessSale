package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.*;
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
            currentSale.addItem(newItem, quantity);
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
            itemReg.updateInventory(currentPayment.getSale().getItemList());
            currentPayment = null;
        }

        return change;
    }

}
