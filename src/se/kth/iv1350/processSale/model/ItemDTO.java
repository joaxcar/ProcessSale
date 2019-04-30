package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.VATRate;

public interface ItemDTO {

    public String getName();

    public double getPrice();

    public double getPriceIncVAT();

    public VATRate getVATRate();

    public String getItemID();

    public String getType();

    public int getQuantity();

    public boolean equalItem(ItemDTO item);
}
