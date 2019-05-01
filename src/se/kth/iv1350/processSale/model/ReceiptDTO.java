package se.kth.iv1350.processSale.model;
import java.util.Date;
import java.util.List;

public class ReceiptDTO {

    private final List<GroupedItem> saleItems;
    private final Date date;
    private final Money payment;
    private final Money change;
    private final String registerID;

    public ReceiptDTO(Sale sale, Money payment, Money change, CashRegister cashReg) {
        this.saleItems = sale.getGroupedItemList();
        this.payment = payment;
        this.change = change;
        this.registerID = cashReg.getRegisterID();
        date = new Date();
    }

    public List<GroupedItem> getSaleItems() {
        return saleItems;
    }

    public Date getDate() {
        return date;
    }

    public Money getPayment() {
        return payment;
    }

    public Money getChange() {
        return change;
    }

    public String getRegisterID() {
        return registerID;
    }
}
