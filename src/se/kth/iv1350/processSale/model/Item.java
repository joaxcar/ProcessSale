package se.kth.iv1350.processSale.model;

public class Item  implements ItemDTO {

    private String name;

    private double price;

    private String itemID;

    private String type;

    private VATRate vatRate;

    public Item(String name, double price, String itemID, String type, VATRate vatRate){
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
        price = 0.0;
        itemID = "";
        type = "";
        vatRate = new VATRate(0);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice(){
        return price;
    }

    @Override
    public double getPriceIncVAT() {
        return price + price * vatRate.getRate();
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
        return itemID.equals(item.getItemID());
    }
}
