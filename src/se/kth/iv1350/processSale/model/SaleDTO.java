package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.ItemDTO;

import java.util.List;
import java.util.Map;

public interface SaleDTO {

    ItemDTO lastAddedItem();

    int lastAddedItemQuantity();

    Amount getRunningTotal();

    int getItemCount();

    Map<String, Integer> getItemList();
}
