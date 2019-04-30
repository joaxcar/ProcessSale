package se.kth.iv1350.processSale.model;

public class GroupedItem extends Item {
    private int quantity;

    public GroupedItem(){
        super();
        quantity = 0;
    }

    public GroupedItem(String name, double price, String itemID, String type, VATRate vatRate, int quantity){
        super( name,  price,  itemID,  type,  vatRate);
        this.quantity = quantity;
    }
    public GroupedItem(ItemDTO item, int quantity){
        super(item);
        this.quantity = quantity;
    }
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
    @Override
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

    public double getTotalPrice(){
        double totalPrice = getPrice();
        totalPrice = totalPrice * quantity;
        return totalPrice;
    }

}

