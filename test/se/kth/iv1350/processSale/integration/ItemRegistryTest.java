package se.kth.iv1350.processSale.integration;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.processSale.model.GroupedItem;
import se.kth.iv1350.processSale.model.Item;
import se.kth.iv1350.processSale.model.ItemDTO;

import static org.junit.jupiter.api.Assertions.*;

class ItemRegistryTest {

    @Test
    void searchItem() {
        ItemRegistry itemRegistry = new ItemRegistry();
        ItemDTO item = new Item("GameBoy", 2000, "0001", "Console", new VATRate(25));
        ItemDTO foundItem = itemRegistry.searchItem("0001");

        assertEquals(item.getItemID(), foundItem.getItemID());
    }

    //@Test
    void updateInventory() {
    }

    @Test
    void printList() {
        ItemRegistry itemRegistry = new ItemRegistry();
        itemRegistry.printList();

    }

    @Test
    void itemDTO() {
        ItemDTO item1 = new Item("GameBoy", 2000, "0001", "Console", new VATRate(25));
        ItemDTO item2 = new GroupedItem(item1, 4);

        System.out.println(item2.getQuantity());
    }
}