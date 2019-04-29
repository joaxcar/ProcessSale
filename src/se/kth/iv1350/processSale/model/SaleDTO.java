package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.GroupedItem;

import java.util.List;

public interface SaleDTO {

    GroupedItem getLastAddedItem();

    Amount getRunningTotal();

    Amount getVAT();

    Amount getRunningTotalIncVAT();

    int getItemCount();

    List<GroupedItem> getItemList();
}
