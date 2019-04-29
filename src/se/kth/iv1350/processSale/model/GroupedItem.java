package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.Item;
import se.kth.iv1350.processSale.integration.ItemDTO;

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

    public void incrementQuantity(){
        quantity += 1;
    }

    public void decrementQuantity(){
        quantity -= 1;
    }

    public ItemDTO getItem(){
        return item;
    }

    public int getQuantity(){
        return quantity;
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
