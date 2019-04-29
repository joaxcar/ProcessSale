package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.ItemDTO;
import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.model.*;
import se.kth.iv1350.processSale.integration.CustomerDTO;

public class SaleController {

    private Sale currentSale;

    private Payment currentPayment;

    private CashRegister cashRegister;
    private ItemRegistry itemReg;

    public SaleController(ItemRegistry itemReg) {
       this.itemReg = itemReg;
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

    public void useDiscount(CustomerDTO customer) {

    }

    public Sale endSale() {
        return null;
    }

    public void pay(Amount paidAmt) {

    }

}
