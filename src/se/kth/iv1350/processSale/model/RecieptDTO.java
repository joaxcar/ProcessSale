package se.kth.iv1350.processSale.model;
import java.util.Date;
import java.util.List;

public class RecieptDTO {

    public final List<GroupedItem> saleItems;
    public final Date date;
    public final Money payment;
    public final Money change;
    public final String registerID;

    public RecieptDTO(Sale sale, Money payment, Money change, CashRegister cashReg) {
        this.saleItems = sale.getGroupedItemList();
        this.payment = payment;
        this.change = change;
        this.registerID = cashReg.getRegisterID();
        date = new Date();
    }
}
