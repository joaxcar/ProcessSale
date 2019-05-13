package se.kth.iv1350.processSale.model;

import java.util.List;

public class SaleDecorator implements Sale{
    protected Sale sale;

    public SaleDecorator(Sale sale){
        this.sale = sale;
    }

    @Override
    public void addItem(ItemDTO newItem) {
        sale.addItem(newItem);
    }

    @Override
    public void addItem(ItemDTO newItem, int quantity) {
        sale.addItem(newItem, quantity);
    }

    @Override
    public SaleStateDTO getSaleState() {
        return sale.getSaleState();
    }

    @Override
    public Money getRunningTotalIncVAT() {
        return sale.getRunningTotalIncVAT();
    }

    @Override
    public List<ItemDTO> getItemList() {
        return sale.getItemList();
    }

    @Override
    public List<GroupedItem> getGroupedItemList() {
        return sale.getGroupedItemList();
    }
}
