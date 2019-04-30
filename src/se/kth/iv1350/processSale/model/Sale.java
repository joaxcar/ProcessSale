package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.GroupedItem;
import se.kth.iv1350.processSale.integration.ItemDTO;

import java.util.ArrayList;
import java.util.List;


/**
 * This class handles sale requests.
 */
public class Sale implements SaleDTO{
    private List<GroupedItem> items;
    private ItemDTO lastAddedItem;

    /**
     * Creates a new instance with an empty item array
     */
    public Sale () {
        items = new ArrayList<GroupedItem>();
    }

    /**
     * Adds an item to <code>Sale</code> object item list. If itemID is not in the list add it,
     * otherwise increment quantity.
     *
     * @param newItem The <code>ItemDTO</code> to add to <code>Sale</code> object
     */
    public void addItem(ItemDTO newItem) {
        lastAddedItem = newItem;
        GroupedItem newGroupedItem = new GroupedItem(lastAddedItem);

        int itemIndex = itemInList(lastAddedItem);
        int notInList = -1;

        if (itemIndex == notInList) {
            items.add(newGroupedItem);
        }
        else if (itemIndex > notInList){
            GroupedItem oldItem = items.get(itemIndex);
            oldItem.incrementQuantity();
        }
    }

    /**
     * Add multiple of the same item.
     *
     * @param newItem The <code>ItemDTO</code> to add to <code>Sale</code> object
     * @param quantity Number of copies to add
     */
    public void addItem(ItemDTO newItem, int quantity){
        for (int i = 0; i < quantity; i++){
            addItem(newItem);
        }
    }

    /*
     * Find ItemDTO in list
     */
    private int itemInList(ItemDTO item){
        int notInList = -1;
        int itemIndex = notInList;
        for (GroupedItem groupItem : items){
            if (groupItem.equalItem(item)){
                itemIndex = items.indexOf(groupItem);
                break;
            }
        }
        return itemIndex;
    }

    /**
     * Returns a copy of the current list of items in <code>Sale</code>
     *
     * @return <code>List</code> of items as <code>GroupedItem</code>
     */
    public List<GroupedItem> getGroupedItemList() {
        List<GroupedItem> itemList = new ArrayList<GroupedItem>(items);
        return itemList;
    }

    /*
     * The rest of the class is implementation of the SaleDTO interface
     */

    /**
     * Returns last added item from <code>Sale</code>
     *
     * @return <code>ItemDTO</code> of last added item
     */
    @Override
    public ItemDTO getLastAddedItem() {
        int itemIndex = itemInList(lastAddedItem);
        int notInList = -1;
        if(itemIndex != notInList) {
            GroupedItem lastAddedGroupedItem = items.get(itemIndex);
            return lastAddedGroupedItem;
        }
        ItemDTO emptyItem = new GroupedItem();
        return emptyItem;
    }

    /**
     * Returns current total price of items in the <code>Sale</code>
     *
     * @return <code>Amount</code> containing total price
     */
    @Override
    public Amount getRunningTotal() {
        Amount runningTotal = new Amount(0);
        for (GroupedItem item : items){
            runningTotal.addAmount(item.getTotalPrice());
        }
        return runningTotal;
    }

    /**
     * Returns total VAT of items in the <code>Sale</code>
     *
     * @return <code>Amount</code> containing total VAT
     */
    @Override
    public Amount getVAT() {
        Amount vatSum = new Amount(0);
        for (GroupedItem item : items){
            Amount price = item.getPrice();
            int quantity = item.getQuantity();
            double vatRate = item.getVATRate().getRate();
            vatSum.addAmount(new Amount(price.getAmount()*quantity*(vatRate)));
        }
        return vatSum;
    }

    /**
     * Returns current price including VAT of items in <code>Sale</code>
     *
     * @return <code>Amount</code> containing total price including VAT
     */
    @Override
    public Amount getRunningTotalIncVAT() {
        Amount totalIncVAT = new Amount(0);
        totalIncVAT.addAmount(getRunningTotal());
        totalIncVAT.addAmount(getVAT());
        return totalIncVAT;
    }

    /**
     * Returns number of items in <code>Sale</code>
     *
     * @return number of items as an integer
     */
    @Override
	public int getItemCount() {
        int count = 0;
        for (GroupedItem item : items){
            count += item.getQuantity();
        }
		return count;
	}

    /**
     * Returns a copy of the current list of items in <code>Sale</code>
     *
     * @return <code>List</code> of items as <code>ItemDTO</code>
     */
    @Override
    public List<ItemDTO> getItemList() {
        List<ItemDTO> itemList = new ArrayList<ItemDTO>(items);
        return itemList;
    }

}
