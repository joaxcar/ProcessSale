package se.kth.iv1350.processSale.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupedItemTest {

    private GroupedItem group;
    private ItemDTO item1;

    @BeforeEach
    void setup(){
        item1 = new ItemDTO("GameBoy", new Money("2000"), "0001", "Console", new VATRate(25));
        group = new GroupedItem(item1);
    }

    @AfterEach
    void teardown(){
        item1 = null;
        group = null;
    }

    @Test
    void testIncrementQuantity() {
        group.incrementQuantity();
        group.incrementQuantity();

        int result = group.getQuantity();

        int expResult = 3;

        assertEquals(expResult, result, "quantity does not match after increment");
    }

    @Test
    void testDecrementQuantity() {
        group.setQuantity(5);
        group.decrementQuantity();
        group.decrementQuantity();

        int result = group.getQuantity();

        int expResult = 3;

        assertEquals(expResult, result, "quantity does not match after decrement");
    }
}