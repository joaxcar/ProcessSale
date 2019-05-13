package se.kth.iv1350.processSale.model;

import java.util.List;

/**
 * This class keeps a list of ItemDTOs representing a sale
 */
public interface Sale {
    /**
     * Add item to sale
     * @param newItem <code>ItemDTO</code> to add to item list
     */
    public void addItem(ItemDTO newItem);

    /**
     * Add multiple of the same item.
     *
     * @param newItem The <code>ItemDTO</code> to add to <code>Sale</code> object
     * @param quantity Number of copies to add
     */
    public void addItem(ItemDTO newItem, int quantity);

    /**
     * Returns a <code>SaleStateDTO</code> containing information of the sale
     *
     * @return <code>SaleStateDTO</code> with current sale info
     */
    public SaleStateDTO getSaleState();

    /**
     * Returns sum of prices from current item list
     *
     * @return current total price
     */
    public Money getRunningTotalIncVAT();

    /**
     * Returns a copy of the current list of items in <code>Sale</code>
     *
     * @return <code>List</code> of items as <code>ItemDTO</code>
     */
    public List<ItemDTO> getItemList();

    /**
     * Returns a copy of the current list of items in <code>Sale</code>
     *
     * @return <code>List</code> of items as <code>GroupedItem</code>
     */
    public List<GroupedItem> getGroupedItemList();
}

