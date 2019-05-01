package se.kth.iv1350.processSale.integration;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.processSale.model.*;

import static org.junit.jupiter.api.Assertions.*;

class ItemRegistryTest {

    @Test
    void searchItem() {
        ItemRegistry itemRegistry = new ItemRegistry();
        ItemDTO item = new ItemDTO("GameBoy", new Money("2000"), "0001", "Console", new VATRate(25));
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
    }
}