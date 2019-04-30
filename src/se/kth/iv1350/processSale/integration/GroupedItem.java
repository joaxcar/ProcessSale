package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Amount;

public class GroupedItem implements ItemDTO {
    ItemDTO item;
    int quantity;

    public GroupedItem(ItemDTO item){
        this.item = item;
        quantity = 1;
    }
    public GroupedItem(ItemDTO item, int quantity){
        this.item = item;
        this.quantity = quantity;
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
     * Returns <code>ItemDTO</code> from <code>GroupedItem</code>
     *
     * @return <code>ItemDTO</code> from object
     */
    public ItemDTO getItem(){
        return item;
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

    public Amount getTotalPrice(){
        Amount totalPrice = item.getPrice();
        totalPrice.multiplyAmount(quantity);
        return totalPrice;
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public Amount getPrice() {
        return item.getPrice();
    }

    @Override
    public Amount getPriceIncVAT() {
        Amount vat = item.getPrice();
        vat.multiplyAmount(item.getVATRate().getRate());
        Amount price = item.getPrice();
        price.addAmount(new Amount(vat));
        return price;
    }

    @Override
    public VATRate getVATRate() {
        return item.getVATRate();
    }

    @Override
    public String getItemID() {
        return item.getItemID();
    }

    @Override
    public String getType() {
        return item.getType();
    }

    public boolean equalItem(ItemDTO item){
        return this.item.getItemID().equals(item.getItemID());
    }

}
