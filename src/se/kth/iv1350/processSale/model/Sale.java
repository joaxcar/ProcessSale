package se.kth.iv1350.processSale.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class keeps a list of ItemDTOs representing a sale
 */
public class Sale {
    private List<ItemDTO> items;

    /**
     * Creates a new instance with an empty item array
     */
    public Sale () {
        items = new ArrayList<ItemDTO>();
    }

    /**
     * Add item to sale
     * @param newItem <code>ItemDTO</code> to add to item list
     */
    public void addItem(ItemDTO newItem) {
        items.add(newItem);
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

    public SaleStateDTO getSaleState(){
        SaleStateDTO saleState = new SaleStateDTO(getRunningTotalIncVAT(),getLastAddedItem());
        return saleState;
    }

    public Money getRunningTotalIncVAT(){
        Money runningTotal = new Money();
        for (ItemDTO item : items){
            runningTotal.add(item.getPriceIncVAT());
        }
        return  runningTotal;
    }

    private ItemDTO getLastAddedItem(){
        int lastIndex = items.size() -1;
        if (lastIndex >= 0){
            return items.get(lastIndex);
        }
        return new Item();
    }

    /**
     * Returns a copy of the current list of items in <code>Sale</code>
     *
     * @return <code>List</code> of items as <code>ItemDTO</code>
     */
    public List<ItemDTO> getItemList() {
        List<ItemDTO> itemListCopy = new ArrayList<ItemDTO>(items);
        return itemListCopy;
    }

    /**
     * Returns a copy of the current list of items in <code>Sale</code>
     *
     * @return <code>List</code> of items as <code>GroupedItem</code>
     */
    public List<GroupedItem> getGroupedItemList() {
        return groupItems();
    }

    /*
     * Convert list of items to grouped items
     */
    private List<GroupedItem> groupItems(){
        List<GroupedItem> groupedList = new ArrayList<GroupedItem>();
        int noItemFound = -1;

        for (ItemDTO item : items){
            int groupIndex = findItemInList(item,groupedList);
            if (groupIndex != noItemFound){
                GroupedItem foundGroup = groupedList.get(groupIndex);
                foundGroup.incrementQuantity();
            }
            else {
                groupedList.add(new GroupedItem(item));
            }
        }
        return groupedList;
    }

    /*
     * Check if ItemDTO is in list of GroupedItems. return index to found item
     */
    private static int findItemInList(ItemDTO item, List<GroupedItem> groupedItems){
        int noItemFound = -1;
        for (GroupedItem group : groupedItems){
            String itemID = item.getItemID();
            if (itemID.equals(group.getItemID())){
                return groupedItems.indexOf(group);
            }
        }
        return noItemFound;
    }

}
