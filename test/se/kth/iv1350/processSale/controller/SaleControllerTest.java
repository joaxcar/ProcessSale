package se.kth.iv1350.processSale.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.integration.Log;
import se.kth.iv1350.processSale.model.ItemDTO;
import se.kth.iv1350.processSale.model.Sale;
import se.kth.iv1350.processSale.model.SaleStateDTO;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SaleControllerTest {

    ItemRegistry itemReg;
    SaleController testController;
    Log log;
    Sale testSale;

    @BeforeEach
    void setup() throws IOException {
        itemReg = new ItemRegistry();
        log = new Log();
        testController = new SaleController(itemReg, log);
        testController.initializeSale();
        testSale = new Sale();
    }

    @AfterEach
    void teardown(){
        itemReg = null;
        testController = null;
        testSale = null;
    }

    @Test
    void testAddingOneItemToSale() throws Exception{
        testController.addItemsToSale(1,"0001");
        SaleStateDTO testSaleState = testController.getSaleState();
        ItemDTO testItem = testSaleState.getLastAddedItem();

        ItemDTO expItem = itemReg.searchItem("0001");

        assertEquals(testItem.getItemID(), expItem.getItemID());
        assertEquals(testSaleState.getRunningTotalIncVAT().toString(), expItem.getPriceIncVAT().toString());
    }

    @Test
    void testEndSale() {
    }

    @Test
    void testGetSaleState() {
    }
}