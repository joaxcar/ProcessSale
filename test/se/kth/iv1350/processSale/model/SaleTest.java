package se.kth.iv1350.processSale.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    private ItemDTO item1;
    private ItemDTO item2;
    private ItemDTO item3;
    private Sale sale;

    @BeforeEach
    void setup(){
        item1 = new ItemDTO("GameBoy", new Money("2000"), "0001", "Console", new VATRate(25));
        item2 = new ItemDTO("Tetris", new Money("340"), "0002", "Game",new VATRate(12));
        item3 = new ItemDTO();
        sale = new Sale();
    }

    @AfterEach
    void teardown(){
        item1 = null;
        item2 = null;
        item3 = null;
        sale = null;
    }

    @Test
    void testAddOneItem() {
        sale.addItem(item1);
        List<ItemDTO> testList = sale.getItemList();

        List<ItemDTO> goodList = new ArrayList<ItemDTO>();
        goodList.add(item1);

        assertEquals(goodList.get(0), testList.get(0), "The items in the two lists are not the same");
    }

    @Test
    void testAddMultipleItems() {
        sale.addItem(item1, 3);
        List<ItemDTO> testList = sale.getItemList();

        List<ItemDTO> goodList = new ArrayList<ItemDTO>();
        goodList.add(item1);
        goodList.add(item1);
        goodList.add(item1);

        assertEquals(goodList.get(0), testList.get(0), "The first items in the lists differ");
        assertEquals(goodList.get(1), testList.get(1), "The second items in the lists differ");
        assertEquals(goodList.get(2), testList.get(2), "The third items in the lists differ");
    }

    @Test
    void testEmptyGetSaleState() {
        SaleStateDTO testSaleState = sale.getSaleState();

        Money testMoney = testSaleState.getRunningTotalIncVAT();
        ItemDTO testItem = testSaleState.getLastAddedItem();

        Money goodMoney = new Money();
        ItemDTO goodItem = new ItemDTO();

        assertEquals(goodMoney.toString(), testMoney.toString(), "Money is not the default Money");
        assertEquals(goodItem.getItemID(), testItem.getItemID(), "Item is not the default Item");
    }

    @Test
    void testActiveGetSaleState() {
        sale.addItem(item1);
        sale.addItem(item2);

        SaleStateDTO testSaleState = sale.getSaleState();
        Money testRunningTotal = testSaleState.getRunningTotalIncVAT();
        ItemDTO testItem = testSaleState.getLastAddedItem();

        Money goodRunningTotal = new Money();
        goodRunningTotal.add(item1.getPriceIncVAT());
        goodRunningTotal.add(item2.getPriceIncVAT());

        ItemDTO goodItem = item2;

        assertEquals(goodRunningTotal.toString(), testRunningTotal.toString(), "Running total does not match");
        assertEquals(goodItem.getItemID(), testItem.getItemID(), "Wrong item as LastAddedItem");
    }

    @Test
    void testGetRunningTotalIncVATMultipleItems() {
        sale.addItem(item1);
        sale.addItem(item2);
        sale.addItem(item3);

        Money testRunningTotal = sale.getRunningTotalIncVAT();

        Money goodRunningTotal = new Money();
        goodRunningTotal.add(item1.getPriceIncVAT());
        goodRunningTotal.add(item2.getPriceIncVAT());
        goodRunningTotal.add(item3.getPriceIncVAT());

        assertEquals(goodRunningTotal.toString(), testRunningTotal.toString(), "Running total does not match");
    }

    @Test
    void testGetRunningTotalIncVATSingleItem() {
        sale.addItem(item1);

        Money testRunningTotal = sale.getRunningTotalIncVAT();

        Money goodRunningTotal = new Money();
        goodRunningTotal.add(item1.getPriceIncVAT());

        assertEquals(goodRunningTotal.toString(), testRunningTotal.toString(), "Running total does not match");
    }

    @Test
    void testGetRunningTotalIncVATNoItems() {
        Money testRunningTotal = sale.getRunningTotalIncVAT();

        Money goodRunningTotal = new Money();

        assertEquals(goodRunningTotal.toString(), testRunningTotal.toString(), "Running total not zero");
    }

    @Test
    void getGroupedItemList() {
        sale.addItem(item1);
        sale.addItem(item1);
        sale.addItem(item2);
        sale.addItem(item2);
        sale.addItem(item2);

        List<GroupedItem> testGroupedItems = sale.getGroupedItemList();

        List<GroupedItem> goodGroupedItems = new ArrayList<GroupedItem>();
        goodGroupedItems.add(new GroupedItem(item1, 2));
        goodGroupedItems.add(new GroupedItem(item2, 3));

        assertEquals(goodGroupedItems.get(0).getItemID(), testGroupedItems.get(0).getItemID());
        assertEquals(goodGroupedItems.get(0).getQuantity(), testGroupedItems.get(0).getQuantity());
        assertEquals(goodGroupedItems.get(1).getItemID(), testGroupedItems.get(1).getItemID());
        assertEquals(goodGroupedItems.get(1).getQuantity(), testGroupedItems.get(1).getQuantity());
    }
}