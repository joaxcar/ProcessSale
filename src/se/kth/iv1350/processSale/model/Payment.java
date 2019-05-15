package se.kth.iv1350.processSale.model;

import java.util.List;

/**
 * Represents a payment. A payment is connected to a <code>Sale</code> and the transaction made to match the total
 * price of the Sale. Once the <code>Sale</code> is contained in a <code>Payment</code> there is no way of altering
 * the sale state.
 */
public class Payment {
    private Sale sale;
    private Money payedAmount;
    private List<RevenueObserver> revenueObservers;

    /**
     * Creates a new instance of <code>Payment</code> associated with given <code>Sale</code>
     *
     * @param sale <code>Sale</code> object to handle
     * @param observers list of observers to be notified of payment
     */
    public Payment(Sale sale, List<RevenueObserver> observers) {
        this.sale = sale;
        this.payedAmount = new Money();
        this.revenueObservers = observers;
    }

    /**
     * Adds an amount of <code>Money</code> to the payment
     *
     * @param amount <code>Money</code> to add to the mayment
     */
    public void add(Money amount){
        payedAmount.add(amount);
    }

    /**
     * Check if amount payed is greater or equals the total price of the <code>Sale</code>
     *
     * @return <code>true</code> if amount is greater or equal to total price
     */
    public boolean checkPaymentDone(){
        boolean paymentDone = payedAmount.greaterThan(new Money(sale.getRunningTotalIncVAT()));
        return paymentDone;
    }

    /**
     * returns amount of <code>Money</code> to return as change
     *
     * @return calculated change between payment and <code>Sale</code> total price
     */
    public Money getChange(){
        return calculateChange();
    }

    /*
     * Calculates change based on payment and total price
     */
    private Money calculateChange(){
        Money totalPrice = sale.getRunningTotalIncVAT();
        Money change = new Money(payedAmount);
        change.subtract(new Money(totalPrice));
        return change;
    }

    /**
     * Returns <code>SaleStateDTO</code> from contained <code>Sale</code> object
     *
     * @return <code>SaleStateDTO</code> from <code>Sale</code>
     */
    public SaleStateDTO getSaleState() {
        return sale.getSaleState();
    }

    /**
     * Returns item list from <code>Sale</code> object contained in <code>Payment</code>
     *
     * @return <code>List</code> of <code>GroupedItem</code>
     */
    public List<GroupedItem> getGroupedItemList() {
        return sale.getGroupedItemList();
    }

    /**
     * Returns current payed amount
     *
     * @return <code>Money</code> object containing currently payed amount
     */
    public Money getPayedAmount() {
        return new Money(payedAmount);
    }

    /**
     * Returns total price of <code>Sale</code>
     *
     * @return <code>Money</code> containing amount of total price
     */
    public Money totalPrice() {
        return sale.getRunningTotalIncVAT();
    }

    /**
     * Make payment transaction. Inform observers
     */
    public void executePayment(){
        if (checkPaymentDone()) {
            CashRegister cashReg = CashRegister.getCashRegister();
            cashReg.addCash(payedAmount);
            cashReg.withdrawCash(calculateChange());
            notifyObservers();
        }
    }

    /*
     * Notify all observers of new payment
     */
    private void notifyObservers() {
        Money revenue = new Money(payedAmount);
        Money change = calculateChange();
        revenue.subtract(change);
        for (RevenueObserver observer : revenueObservers){
            observer.newPayment(revenue);
        }
    }
}
