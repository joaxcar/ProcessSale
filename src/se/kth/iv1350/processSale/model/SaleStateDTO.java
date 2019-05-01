package se.kth.iv1350.processSale.model;

public class SaleStateDTO {

    Money runningTotalIncVAT;
    ItemDTO lastAddedItem;

    public SaleStateDTO(Money runningTotalIncVAT, ItemDTO lastAddedItem) {
        this.runningTotalIncVAT = runningTotalIncVAT;
        this.lastAddedItem = lastAddedItem;
    }

    public Money getRunningTotalIncVAT() {
        return runningTotalIncVAT;
    }

    public ItemDTO getLastAddedItem() {
        return lastAddedItem;
    }

}

