package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.ItemDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * Adds an item to <code>Sale</code> object item list
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


    @Override
    public GroupedItem getLastAddedItem() {
        int itemIndex = itemInList(lastAddedItem);
        GroupedItem lastAddedGroupedItem = items.get(itemIndex);
        return lastAddedGroupedItem;
    }

    @Override
    public Amount getRunningTotal() {
        Amount runningTotal = new Amount(0);
        for (GroupedItem item : items){
            runningTotal.addAmount(item.getTotalPrice());
        }
        return runningTotal;
    }

	@Override
	public int getItemCount() {
        int count = 0;
        for (GroupedItem item : items){
            count += item.getQuantity();
        }
		return count;
	}

    @Override
    public List<GroupedItem> getItemList() {
        List<GroupedItem> itemList = new ArrayList<GroupedItem>(items);
        return itemList;
    }
}
