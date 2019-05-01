package se.kth.iv1350.processSale.model;

public interface ItemDTO {

    String getName();

    Money getPrice();

    Money getPriceIncVAT();

    VATRate getVATRate();

    String getItemID();

    String getType();

    int getQuantity();

    boolean equalItem(ItemDTO item);
}
