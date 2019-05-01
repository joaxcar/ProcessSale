package se.kth.iv1350.processSale.model;

public class ItemDTO {

    private String name;

    private Money price;

    private String itemID;

    private String type;

    private VATRate vatRate;

    public ItemDTO(String name, Money price, String itemID, String type, VATRate vatRate){
        this.name = name;
        this.price = price;
        this.itemID = itemID;
        this.type = type;
        this.vatRate = vatRate;
    }


    public ItemDTO(ItemDTO item){
        name = item.getName();
        price = item.getPrice();
        itemID = item.getItemID();

        type = item.getType();
        vatRate = item.getVATRate();
    }

    public ItemDTO() {
        name = "";
        price = new Money("0");
        itemID = "";
        type = "";
        vatRate = new VATRate(0);
    }

    public String getName() {
        return name;
    }

    public Money getPrice(){
        return price;
    }

    public Money getPriceIncVAT() {
        Money priceIncVAT = new Money();
        Money vatAmount = new Money(Double.toString(vatRate.getRate()));
        priceIncVAT.add(price);
        priceIncVAT.add(vatAmount);
        return priceIncVAT;
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

    public boolean equalItem(ItemDTO item) {
        return itemID.equals(item.getItemID());
    }

}
