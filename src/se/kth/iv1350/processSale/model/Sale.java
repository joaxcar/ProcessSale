package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.ItemDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sale implements SaleDTO{
    private List<ItemDTO> items;

    /**
     * Creates a new instance with an empty item array
     */
    public Sale () {
        items = new ArrayList<ItemDTO>();
    }

    /**
     * Adds an item to <code>Sale</code> object item list
     *
     * @param newItem The <code>ItemDTO</code> to add to <code>Sale</code> object
     */
    public void addItem(ItemDTO newItem) {
        items.add(newItem);
    }


    @Override
    public ItemDTO lastAddedItem() {
        int lastIndex = items.size() - 1;
        return items.get(lastIndex);
    }

    @Override
    public int lastAddedItemQuantity() {
        int lastIndex = items.size() - 1;
        ItemDTO lastAddedItem = lastAddedItem();
        int quantity = 0;

        if (lastAddedItem != null){
            for (int i = lastIndex; items.get(i).equals(lastAddedItem); i--){
                quantity += 1;
            }
        }
        return quantity;
    }

    @Override
    public Amount getRunningTotal() {
        Amount runningTotal = new Amount(0);
        for (ItemDTO item : items){
            runningTotal.addAmount(item.getPrice());
        }
        return runningTotal;
    }

	@Override
	public int getItemCount() {
		return items.size();
	}

    @Override
    public Map<String, Integer> getItemList() {
        Map<String, Integer> itemCounts = new HashMap<String, Integer>();

        for (ItemDTO item : items) {
            if (itemCounts.containsKey(item.getName())) {
                itemCounts.put(item.getName(), itemCounts.get(item.getName()) + 1);
            } else {
                itemCounts.put(item.getName(), 1);
            }
        }
        return itemCounts;
    }
}
