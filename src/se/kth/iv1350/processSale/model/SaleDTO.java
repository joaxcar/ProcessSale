package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.ItemDTO;

import java.util.List;

public interface SaleDTO {

    ItemDTO lastAddedItem();

    int lastAddedItemQuantity();

    Amount getRunningTotal();
}
