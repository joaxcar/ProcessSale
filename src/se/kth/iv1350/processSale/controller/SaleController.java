package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.*;
import se.kth.iv1350.processSale.model.*;

import java.util.List;

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


    public double getRunningTotalIncVAT(){
        return currentSale.getRunningTotalIncVAT();
    }
    /**
     * Returns number of items in <code>Sale</code>
     *
     * @return number of items as an integer
     */
    public int getItemCount() {
        List<ItemDTO> itemList = currentSale.getItemList();
        return itemList.size();
    }

    public ItemDTO getLastAddedItem(){
        List<ItemDTO> itemList = currentSale.getItemList();
        int lastIndex = itemList.size() -1;
        if (lastIndex >= 0){
            ItemDTO lastAddedItem = itemList.get(lastIndex);
            return lastAddedItem;
        }
        return new Item();
    }
}
