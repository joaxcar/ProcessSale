package se.kth.iv1350.processSale.model;

/**
 * This class stores attributes from sale that are relevant during sale process, as a DTO
 */
public class SaleStateDTO {

    Money runningTotalIncVAT;
    ItemDTO lastAddedItem;

    /**
     * Create new instance of <code>SaleStateDTO</code>
     *
     * @param runningTotalIncVAT current total price of sale
     * @param lastAddedItem current item last added to sale
     */
    public SaleStateDTO(Money runningTotalIncVAT, ItemDTO lastAddedItem) {
        this.runningTotalIncVAT = runningTotalIncVAT;
        this.lastAddedItem = lastAddedItem;
    }

    /**
     * Returns total price
     *
     * @return running total
     */
    public Money getRunningTotalIncVAT() {
        return runningTotalIncVAT;
    }

    /**
     * Returns last added item
     *
     * @return last added item
     */
    public ItemDTO getLastAddedItem() {
        return lastAddedItem;
    }
}

