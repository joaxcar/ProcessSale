package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.ItemDTO;

import java.util.List;

public class SaleStateDTO {
    private List<ItemDTO> items;

    public ItemDTO lastAddedItem(){
        return items.get(items.size());
    }


    private Amount runingTotal;

    private int itemCount;

    private Amount totalVAT;

    public SaleStateDTO(Amount amount){
        runingTotal = amount;
    }

    public String getItemDescription() {
        return null;
    }

    public String getRunningTotal() {
        return runingTotal.toString();
    }

    public Amount getVATtotal() {
        return null;
    }

    public Amount getItemPrice() {
        return null;
    }

    public String getItemName() {
        return null;
    }

    public void getItemQuantity() {

    }

}
