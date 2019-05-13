package se.kth.iv1350.processSale.integration;


import se.kth.iv1350.processSale.model.GroupedItem;
import se.kth.iv1350.processSale.model.ItemDTO;
import se.kth.iv1350.processSale.model.Money;
import se.kth.iv1350.processSale.model.VATRate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Keeps list of items from database. Handel searches of items.
 */
public class ItemRegistry {
    private List<GroupedItem> availableItems = new ArrayList<GroupedItem>();

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
        ItemDTO item1 = new ItemDTO("GameBoy", new Money("2000"), "0001", "Console", new VATRate(25));
        ItemDTO item2 = new ItemDTO("Tetris", new Money("340"), "0002", "Game",new VATRate(12));
        ItemDTO item3 = new ItemDTO("Super Mario 2", new Money("290"), "0003", "Game",new VATRate(25));
        ItemDTO item4 = new ItemDTO("Mario figure", new Money("96"), "0004", "Collectable",new VATRate(12));
        ItemDTO item5 = new ItemDTO("Zelda", new Money("300"), "0005", "Game",new VATRate(12));
        ItemDTO item6 = new ItemDTO("AAA batteries", new Money("25"), "0006", "Misc",new VATRate(6));

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
     * @throws NoItemFoundException if no item is found
     * @throws SQLException if database error occurs
     */
    public ItemDTO searchItem(String searchedID) throws NoItemFoundException, ItemRegistryException {
        // This is part of seminar 4, hardcoded failure to simulate database error
        if (searchedID == "0000"){
            throw new ItemRegistryException("Failed to search registry", new SQLException());
        }

        for (ItemDTO item : availableItems){
            if (item.getItemID().equals(searchedID)){
                return item;
            }
        }

        throw new NoItemFoundException(searchedID);
    }

    /**
     * Removes specified items from inventory
     *
     * @param items <code>List</code> of <code>GroupedItem</code> to remove from inventory
     */
    public void subtractFromInventory(List<GroupedItem> items) {
        System.out.println("Updating registry items with information from sale");
    }
}
