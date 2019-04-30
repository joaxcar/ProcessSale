package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Amount;

public interface ItemDTO {

    public String getName();

    public Amount getPrice();

    public Amount getPriceIncVAT();

    public VATRate getVATRate();

    public String getItemID();

    public String getType();

    public int getQuantity();
}
