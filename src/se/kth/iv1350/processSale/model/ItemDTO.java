package se.kth.iv1350.processSale.model;
import java.util.Objects;

public interface ItemDTO {

    String getName();

    Money getPrice();

    Money getPriceIncVAT();

    VATRate getVATRate();

    String getItemID();

    String getType();

    int getQuantity();

}
