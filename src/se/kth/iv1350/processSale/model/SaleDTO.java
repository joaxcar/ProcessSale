package se.kth.iv1350.processSale.model;

import java.util.List;

public interface SaleDTO {

    List<ItemDTO> getItemList();
    List<GroupedItem> getGroupedItemList();

    double getRunningTotalIncVAT();
    double getVAT();
    double getRunningTotal();
}
