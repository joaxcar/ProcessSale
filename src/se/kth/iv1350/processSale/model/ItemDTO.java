package se.kth.iv1350.processSale.model;

/**
 * This class stores attributes of an item as a DTO
 */
public class ItemDTO {

    private String name;
    private Money price;
    private String itemID;
    private String type;
    private VATRate vatRate;

    /**
     * Create new instance of <code>ItemDTO</code>
     *
     * @param name name of item
     * @param price price of item
     * @param itemID item ID
     * @param type type of item
     * @param vatRate VAT rate of item
     */
    public ItemDTO(String name, Money price, String itemID, String type, VATRate vatRate){
        this.name = name;
        this.price = price;
        this.itemID = itemID;
        this.type = type;
        this.vatRate = vatRate;
    }

    /**
     * Creates a copy of an <code>ItemDTO</code>
     *
     * @param item item to copy
     */
    public ItemDTO(ItemDTO item){
        name = item.getName();
        price = item.getPrice();
        itemID = item.getItemID();

        type = item.getType();
        vatRate = item.getVATRate();
    }

    /**
     * Creates new default <code>ItemDTO</code>
     */
    public ItemDTO() {
        name = "";
        price = new Money("0");
        itemID = "";
        type = "";
        vatRate = new VATRate(0);
    }

    /**
     * Get item name
     *
     * @return item name
     */
    public String getName() {
        return name;
    }

    /**
     * Get item price
     *
     * @return item price
     */
    public Money getPrice(){
        return price;
    }

    /**
     * Get item price including VAT
     *
     * @return price including VAT
     */
    public Money getPriceIncVAT() {
        Money priceIncVAT = new Money();
        Money vatAmount = new Money(Double.toString(vatRate.getRate()));
        priceIncVAT.add(price);
        priceIncVAT.add(vatAmount);
        return priceIncVAT;
    }

    /**
     * Get item VAT rate
     *
     * @return VAT rate
     */
    public VATRate getVATRate(){
        return vatRate;
    }

    /**
     * Get item ID
     *
     * @return item ID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * Get item type
     *
     * @return item type
     */
    public String getType() {
        return type;
    }

    /**
     * Check if two items has the same ID
     *
     * @return true if equal
     */
    public boolean equalItem(ItemDTO item) {
        return itemID.equals(item.getItemID());
    }
}
