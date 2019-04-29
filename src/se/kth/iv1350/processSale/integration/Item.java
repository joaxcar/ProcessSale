package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Amount;

public class Item  implements ItemDTO{

    private String name;

    private Amount price;

    private String itemID;

    private String type;

    private VATRate vatRate;

    public Item(String name, Amount price, String itemID, String type, VATRate vatRate){
        this.name = name;
        this.price = price;
        this.itemID = itemID;
        this.type = type;
        this.vatRate = vatRate;
    }

    public String getName() {
        return name;
    }

    public Amount getPrice(){
        return new Amount(price);
    }

    public VATRate getVATRate(){
        return vatRate;
    }

    public String getItemID() {
        return itemID;
    }

    public String getType() {
        return type;
    }
}
