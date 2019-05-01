package se.kth.iv1350.processSale.controller;


import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.model.ItemDTO;
import se.kth.iv1350.processSale.model.Sale;
import se.kth.iv1350.processSale.model.SaleStateDTO;

public class SaleController {

    private Sale currentSale;
    private ItemRegistry itemReg;

    public SaleController(ItemRegistry itemReg) {
       this.itemReg = itemReg;
    }

    public void initializeSale() {
        currentSale = new Sale();
    }

    public void addItemsToSale(int quantity, String itemID) {
        ItemDTO newItem = itemReg.searchItem(itemID);

        if (newItem != null) {
            currentSale.addItem(newItem, quantity);
        }
    }

    public void endSale(PaymentController paymentContr) {
        paymentContr.initializePayment(currentSale);
        currentSale = null;
    }

    public SaleStateDTO getSaleState(){
        return currentSale.getSaleState();
    }

}
