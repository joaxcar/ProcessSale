package se.kth.iv1350.processSale.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.processSale.integration.NoItemFoundException;
import se.kth.iv1350.processSale.model.BasicSale;
import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.model.ItemDTO;
import se.kth.iv1350.processSale.model.Sale;
import se.kth.iv1350.processSale.model.SaleStateDTO;


import static org.junit.jupiter.api.Assertions.*;

class SaleControllerTest {

    ItemRegistry itemReg;
    SaleController testController;
    Sale testSale;

    @BeforeEach
    void setup() {
        itemReg = new ItemRegistry();
        testController = new SaleController(itemReg);
        testController.initializeSale();
        testSale = new BasicSale();
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
    void testAddingNonExistingItemToSale() throws OperationFailedException{
        String exceptionMessage = "fail";
        try{
            testController.addItemsToSale(1,"doesNotExist");
        } catch (NoItemFoundException ex){
            exceptionMessage = ex.getMessage();
        }

        String expectedMessage = "No item in registry matching itemID: doesNotExist";

        assertEquals(expectedMessage, exceptionMessage, "Messages mismatch");
    }

    @Test
    void testAddingItemToSaleRegistryFail() throws NoItemFoundException{
        String exceptionMessage = "fail";
        try{
            testController.addItemsToSale(1,"0000");
        } catch (OperationFailedException ex){
            exceptionMessage = ex.getMessage();
        }

        String expectedMessage = "Failed to add item to sale";

        assertEquals(expectedMessage, exceptionMessage, "Messages mismatch");
    }

    @Test
    void testAddingItemToSaleWithNoActiveSale() throws NoItemFoundException{
        String exceptionMessage = "fail";

        testController = new SaleController(new ItemRegistry());

        try{
            testController.addItemsToSale(1,"0001");
        } catch (OperationFailedException ex){
            exceptionMessage = ex.getMessage();
        }

        String expectedMessage = "No active sale, create new sale";

        assertEquals(expectedMessage, exceptionMessage, "Messages mismatch");
    }


    @Test
    void testEndSale() {
    }

    @Test
    void testGetSaleState() {
    }
}