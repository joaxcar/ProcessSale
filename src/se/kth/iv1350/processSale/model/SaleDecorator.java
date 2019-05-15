package se.kth.iv1350.processSale.model;

import java.util.List;

/**
 * Standard implantation of <code>Sale</code> object decorator. Extend this class to create decorators
 */
public class SaleDecorator implements Sale{
    protected Sale sale;

    /**
     * Create new instance of <code>SaleDecorator</code>
     *
     * @param sale <code>Sale</code> to decorate
     */
    public SaleDecorator(Sale sale){
        this.sale = sale;
    }

    /**
     * Add item to decorated <code>Sale</code>
     *
     * @param newItem <code>ItemDTO</code> to add to item list
     */
    @Override
    public void addItem(ItemDTO newItem) {
        sale.addItem(newItem);
    }

    /**
     * Add multiple items to decorated <code>Sale</code>
     *
     * @param newItem The <code>ItemDTO</code> to add to <code>Sale</code> object
     * @param quantity Number of copies to add
     */
    @Override
    public void addItem(ItemDTO newItem, int quantity) {
        sale.addItem(newItem, quantity);
    }

    /**
     * Returns sale state
     *
     * @return <code>SaleStateDTO</code> containing current <code>Sale</code> state
     */
    @Override
    public SaleStateDTO getSaleState() {
        return sale.getSaleState();
    }

    /**
     * Returns running total of decorated <code>Sale</code>
     *
     * @return current total price
     */
    @Override
    public Money getRunningTotalIncVAT() {
        return sale.getRunningTotalIncVAT();
    }

    /**
     * Returns list of <code>ItemDTO</code>s in decorated <code>Sale</code>
     *
     * @return list of items
     */
    @Override
    public List<ItemDTO> getItemList() {
        return sale.getItemList();
    }

    /**
     * Returns list of items in <code>Sale</code> as <code>GroupedItem</code>
     *
     * @return grouped list of items
     */
    @Override
    public List<GroupedItem> getGroupedItemList() {
        return sale.getGroupedItemList();
    }
}
