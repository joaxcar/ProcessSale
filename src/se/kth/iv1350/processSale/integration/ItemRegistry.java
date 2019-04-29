package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Amount;
import se.kth.iv1350.processSale.model.SaleDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Keeps list of items from database. Handel searches of items.
 */
public class ItemRegistry {
    List<ItemDTO> availableItems = new ArrayList<ItemDTO>();

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
        ItemDTO item1 = new Item("GameBoy", new Amount(2000), "0001", "Console", new VATRate(25));
        ItemDTO item2 = new Item("Tetris", new Amount(340), "0002", "Game",new VATRate(12));
        ItemDTO item3 = new Item("Super Mario 2", new Amount(280), "0003", "Game",new VATRate(25));
        ItemDTO item4 = new Item("Mario figure", new Amount(95), "0004", "Collectable",new VATRate(12));
        ItemDTO item5 = new Item("Zelda", new Amount(300), "0005", "Game",new VATRate(12));
        ItemDTO item6 = new Item("AAA batteries", new Amount(19), "0006", "Misc",new VATRate(6));

        availableItems.add(item1);
        availableItems.add(item2);
        availableItems.add(item3);
        availableItems.add(item4);
        availableItems.add(item5);
        availableItems.add(item6);
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

    public void updateInventory(List<ItemDTO> items) {

    }

}
