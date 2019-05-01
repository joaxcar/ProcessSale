package se.kth.iv1350.processSale.model;

public class Item  implements ItemDTO {

    private String name;

    private Money price;

    private String itemID;

    private String type;

    private VATRate vatRate;

    public Item(String name, Money price, String itemID, String type, VATRate vatRate){
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
        price = new Money("0");
        itemID = "";
        type = "";
        vatRate = new VATRate(0);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Money getPrice(){
        return price;
    }

    @Override
    public Money getPriceIncVAT() {
        Money priceIncVAT = new Money();
        Money vatAmount = new Money(Double.toString(vatRate.getRate()));
        priceIncVAT.add(price);
        priceIncVAT.add(vatAmount);
        return priceIncVAT;
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
        if (itemID.equals("")){
            return 0;
        }
        return 1;
    }

    public boolean equalItem(ItemDTO item) {
        return itemID.equals(item.getItemID());
    }

}
