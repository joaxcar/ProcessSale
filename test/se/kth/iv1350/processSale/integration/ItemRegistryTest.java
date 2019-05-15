package se.kth.iv1350.processSale.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.processSale.model.*;

import static org.junit.jupiter.api.Assertions.*;

class ItemRegistryTest {
    private ItemRegistry itemRegistry;

    @BeforeEach
    void setup(){
         itemRegistry = new ItemRegistry();
    }

    @Test
    void searchItem() throws NoItemFoundException, ItemRegistryException {

        ItemDTO item = new ItemDTO("GameBoy", new Money("2000"), "0001", "Console", new VATRate(25));
        ItemDTO foundItem = itemRegistry.searchItem("0001");

        assertEquals(item.getItemID(), foundItem.getItemID());
    }

    @Test
    void testWrongItemIDinSearch() throws ItemRegistryException{
        String testValue = "doesNotExist";
        try{
           itemRegistry.searchItem(testValue);
        }
        catch (NoItemFoundException ex){
            assertEquals(testValue, ex.getSearchedItemID(), "ItemID in exception does not match expItemID");
            assertEquals("No item in registry matching itemID: " + ex.getSearchedItemID(), ex.getMessage(), "Message in exception does not match expMessage");
        }
    }

    @Test
    void testDatabaseError() throws NoItemFoundException{
        String testValue = "0000";
        String expMessage = "Failed to search registry";
        try{
            itemRegistry.searchItem(testValue);
        }
        catch (ItemRegistryException ire){
            assertEquals(ire.getMessage(), expMessage, "Wrong message after ItemRegistryExcepttion");
        }
    }

}