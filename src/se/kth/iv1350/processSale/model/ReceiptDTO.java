package se.kth.iv1350.processSale.model;
import java.util.Date;
import java.util.List;

/**
 * This class stores attributes related to a receipt as a DTO
 */
public class ReceiptDTO {

    private final List<GroupedItem> saleItems;
    private final Date date;
    private final Money price;
    private final Money payment;
    private final Money change;
    private final String registerID;

    /**
     * Create new instance of <code>Receipt</code>
     *
     * @param payment payment to create receipt from
     */
    public ReceiptDTO(Payment payment) {
        saleItems = payment.getGroupedItemList();
        this.payment = payment.getPayedAmount();
        change = payment.getChange();
        registerID = CashRegister.getCashRegister().getRegisterID();
        price = payment.getRunningTotalIncVAT();
        date = new Date();
    }

    /**
     * Get list of items
     *
     * @return list of <code>GroupedItem</code>
     */
    public List<GroupedItem> getSaleItems() {
        return saleItems;
    }

    /**
     * Get date of sale
     *
     * @return date of sale
     */
    public Date getDate() {
        return date;
    }

    /**
     * Get payed amount
     *
     * @return payment value
     */
    public Money getPayment() {
        return payment;
    }

    /**
     * Get change amount
     *
     * @return change value
     */
    public Money getChange() {
        return change;
    }

    /**
     * Get register ID of used cash register
     *
     * @return register ID
     */
    public String getRegisterID() {
        return registerID;
    }

    /**
     * Get receipt as a <code>String</code>
     *
     * @return string representation of receipt
     */
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
