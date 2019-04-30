package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.GroupedItem;
import se.kth.iv1350.processSale.integration.ItemDTO;

import java.util.List;

public interface SaleDTO {

    ItemDTO getLastAddedItem();

    Amount getRunningTotal();

    Amount getVAT();

    Amount getRunningTotalIncVAT();

    int getItemCount();

    List<ItemDTO> getItemList();
}
