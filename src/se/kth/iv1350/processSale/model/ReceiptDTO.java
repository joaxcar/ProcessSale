package se.kth.iv1350.processSale.model;
import java.util.Date;
import java.util.List;

public class ReceiptDTO {

    private final List<GroupedItem> saleItems;
    private final Date date;
    private final Money price;
    private final Money payment;
    private final Money change;
    private final String registerID;

    public ReceiptDTO(Sale sale, Money payment, Money change, CashRegister cashReg) {
        this.saleItems = sale.getGroupedItemList();
        this.payment = payment;
        this.change = change;
        this.registerID = cashReg.getRegisterID();
        this.price = sale.getRunningTotalIncVAT();
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

    @Override
    public String toString(){
        StringBuilder receipt = new StringBuilder();
        receipt.append("Date: " + date + "\n");
        receipt.append("Cash register: " + registerID + "\n");
        receipt.append("------------------------: " + "\n");
        for (GroupedItem group : saleItems){
            receipt.append(group.toString() + "\n");
        }
        receipt.append("------------------------: " + "\n");
        receipt.append("Total price: " + price + "\n");
        receipt.append("Payed: " + payment + "\n");
        receipt.append("Change: " + change + "\n");
        return receipt.toString();
    }
}
