package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps list of items from database. Handel searches of items.
 */
public class ItemRegistry {
    List<GroupedItem> availableItems = new ArrayList<GroupedItem>();

    /**
     * Creates new instance, adds items to list of available items
     */
    public ItemRegistry() {
        addItems();
    }

    /*
     * Adds items to availableItems list
     */
    private void addItems() {
        ItemDTO item1 = new Item("GameBoy", 2000, "0001", "Console", new VATRate(25));
        ItemDTO item2 = new Item("Tetris", 340, "0002", "Game",new VATRate(12));
        ItemDTO item3 = new Item("Super Mario 2", 280, "0003", "Game",new VATRate(25));
        ItemDTO item4 = new Item("Mario figure", 95, "0004", "Collectable",new VATRate(12));
        ItemDTO item5 = new Item("Zelda", 300, "0005", "Game",new VATRate(12));
        ItemDTO item6 = new Item("AAA batteries", 19, "0006", "Misc",new VATRate(6));

        availableItems.add(new GroupedItem(item1, 4));
        availableItems.add(new GroupedItem(item2, 3));
        availableItems.add(new GroupedItem(item3,6));
        availableItems.add(new GroupedItem(item4, 1));
        availableItems.add(new GroupedItem(item5, 4));
        availableItems.add(new GroupedItem(item6, 2));
    }

    /**
     * Searches list of available items for one matching given ID string
     *
     * @param searchedID String to match against <code>ItemDTO</code> ID
     * @return matching <code>ItemDTO</code> if found otherwise null
     */
    public ItemDTO searchItem(String searchedID) {
        for (ItemDTO item : availableItems){
            if (item.getItemID().equals(searchedID)){
                return item;
            }
        }
        return null;
    }

    public void updateInventory(Sale sale) {
        for (GroupedItem saleItem : sale.getGroupedItemList()){
            for (GroupedItem inventoryItem : availableItems){
                if (saleItem.getItemID().equals(inventoryItem.getItemID())){
                    inventoryItem.setQuantity(inventoryItem.getQuantity()-saleItem.getQuantity());
                    break;
                }
            }
        }
    }

    public void printList(){
        System.out.println("Inventory list: ");
        for (GroupedItem item : availableItems){
            System.out.println(item.getName() + " : " + item.getQuantity());
        }
    }

}
