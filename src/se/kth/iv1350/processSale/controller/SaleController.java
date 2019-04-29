package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.ItemDTO;
import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.integration.Log;
import se.kth.iv1350.processSale.model.*;

public class SaleController {

    private Sale currentSale;

    private Payment currentPayment;

    private CashRegister cashRegister;
    private ItemRegistry itemReg;
    private Log log;

    public SaleController(ItemRegistry itemReg, Log log) {
       this.itemReg = itemReg;
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
        return null;
    }

    public void pay(Amount paidAmt) {

    }

}
