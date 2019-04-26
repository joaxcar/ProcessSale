package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Amount;

public class ItemDTO {

    private String name;

    private Amount price;

    private String itemID;

    private String type;

    public ItemDTO(String name, Amount price, String itemID, String type){
        this.name = name;
        this.price = price;
        this.itemID = itemID;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Amount getPrice(){
        return price;
    }

    public String getItemID() {
        return itemID;
    }

    public String getType() {
        return type;
    }
}
