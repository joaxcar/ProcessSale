package se.kth.iv1350.processSale.model;

/**
 * This class extends the <code>ItemDTO</code> to add the possibility of having a quantity related to an item
 */
public class GroupedItem extends ItemDTO {
    private int quantity;

    /**
     * Create empty instance of <code>GroupedItem</code>, sets quantity to 0
     */
    public GroupedItem(){
        super();
        quantity = 0;
    }

    /**
     * Create new instance of <code>GroupedItem</code>, set attributes according to parameters
     * @param name Used for item name
     * @param price Used for item price
     * @param itemID Used for itemID
     * @param type Used for item type
     * @param vatRate Used for item <code>VATRate</code>
     * @param quantity Used for initial quantity
     */
    public GroupedItem(String name, Money price, String itemID, String type, VATRate vatRate, int quantity){
        super( name,  price,  itemID,  type,  vatRate);
        this.quantity = quantity;
    }

    /**
     * Create new instance of <code>GroupedItem</code>, set attributes according to parameters
     *
     * @param item Used to create item
     * @param quantity Used for initial quantity
     */
    public GroupedItem(ItemDTO item, int quantity){
        super(item);
        this.quantity = quantity;
    }

    /**
     * Create new instance of <code>GroupedItem</code>, set attributes according to parameters and initial quantity to 1
     *
     * @param item Used for item
     */
    public GroupedItem(ItemDTO item){
        super(item);
        quantity = 1;
    }

    /**
     * Increments quantity of <code>GroupedItem</code>
     */
    public void incrementQuantity(){
        quantity += 1;
    }

    /**
     * Decrements quantity of <code>GroupedItem</code>
     */
    public void decrementQuantity(){
        quantity -= 1;
    }

    /**
     * Returns quantity of <code>GroupedItem</code>
     *
     * @return quantity of item
     */
    public int getQuantity(){
        return quantity;
    }

    /**
     * Set quantity of <code>GroupedItem</code>
     *
     * @param quantity value of new quantity
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    /**
     * Get gouped item as a <code>String</code>
     *
     * @return <code>String</code> representing item and quantity
     */
    @Override
    public String toString(){
        String itemCount = new String(super.getName() + " : " + quantity);
        return itemCount;
    }
}
