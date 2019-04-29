package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.ItemDTO;

import java.util.List;
import java.util.Map;

public interface SaleDTO {

    GroupedItem getLastAddedItem();

    Amount getRunningTotal();

    Amount getVAT();

    Amount getRunningTotalIncVAT();

    int getItemCount();

    List<GroupedItem> getItemList();
}
