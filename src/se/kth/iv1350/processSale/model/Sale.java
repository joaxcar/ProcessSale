package se.kth.iv1350.processSale.model;

import java.util.ArrayList;
import java.util.List;


/**
 * This class handles sale requests.
 */
public class Sale implements SaleDTO{
    private List<ItemDTO> items;

    /**
     * Creates a new instance with an empty item array
     */
    public Sale () {
        items = new ArrayList<ItemDTO>();
    }

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


    /**
     * Returns a copy of the current list of items in <code>Sale</code>
     *
     * @return <code>List</code> of items as <code>GroupedItem</code>
     */
    public List<GroupedItem> getGroupedItemList() {
        List<GroupedItem> itemList = groupItems();
        return itemList;
    }

    private List<GroupedItem> groupItems(){
        List<GroupedItem> groupedList = new ArrayList<GroupedItem>();
        int noItemFound = -1;
        for (ItemDTO item : items){
            int groupIndex = findItemInList(item,groupedList);
            if (groupIndex != noItemFound){
                GroupedItem foundGroup = groupedList.get(groupIndex);
                foundGroup.incrementQuantity();
                break;
            }
            groupedList.add(new GroupedItem(item));
        }
        return groupedList;
    }

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
    /**
     * Returns current total price of items in the <code>Sale</code>
     *
     * @return <code>Amount</code> containing total price
     */
    public double getRunningTotal() {
        double runningTotal = 0.0;
        for (ItemDTO item : items){
            runningTotal += item.getPrice();
        }
        return runningTotal;
    }

    /**
     * Returns total VAT of items in the <code>Sale</code>
     *
     * @return <code>Amount</code> containing total VAT
     */
    public double getVAT() {
        double vatSum = 0.0;
        for (ItemDTO item : items){
            double price = item.getPrice();
            double vatRate = item.getVATRate().getRate();
            vatSum += price * vatRate;
        }
        return vatSum;
    }

    /**
     * Returns current price including VAT of items in <code>Sale</code>
     *
     * @return <code>Amount</code> containing total price including VAT
     */
    public double getRunningTotalIncVAT() {
        double totalIncVAT = 0.0;
        totalIncVAT += getRunningTotal();
        totalIncVAT += getVAT();
        return totalIncVAT;
    }


}
