package se.kth.iv1350.processSale.model;

public interface ItemDTO {

    String getName();

    double getPrice();

    double getPriceIncVAT();

    VATRate getVATRate();

    String getItemID();

    String getType();

    int getQuantity();

    boolean equalItem(ItemDTO item);
}
