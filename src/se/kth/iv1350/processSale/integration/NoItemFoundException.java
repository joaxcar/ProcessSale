package se.kth.iv1350.processSale.integration;

/**
 * Thrown when item is not found in item registry
 */
public class NoItemFoundException extends Exception {
    final String searchedItemID;

    /**
     * Create new instance with message specifying which item ID was searched for
     *
     * @param searchedItemID <code>String</code> searched for
     */
    public NoItemFoundException(String searchedItemID) {
        super("No item in registry matching itemID: " + searchedItemID);
        this.searchedItemID = searchedItemID;
    }

    public String getSearchedItemID(){
        return searchedItemID;
    }
}
