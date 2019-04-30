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

    public Item(ItemDTO item){
        name = item.getName();
        price = item.getPrice();
        itemID = item.getItemID();
        type = item.getType();
        vatRate = item.getVATRate();
    }

    public Item() {
        name = "";
        price = new Amount(0);
        itemID = "";
        type = "";
        vatRate = new VATRate(0);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Amount getPrice(){
        return new Amount(price);
    }

    @Override
    public Amount getPriceIncVAT() {
        double priceIncVAT = price.getAmount() + price.getAmount() * vatRate.getRate();
        return new Amount(priceIncVAT);
    }

    @Override
    public VATRate getVATRate(){
        return vatRate;
    }

    @Override
    public String getItemID() {
        return itemID;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int getQuantity() {
        if (itemID == ""){
            return 0;
        }
        return 1;
    }

    @Override
    public boolean equalItem(ItemDTO item) {
        boolean equal = itemID.equals(item.getItemID());
        return  equal;
    }
}
