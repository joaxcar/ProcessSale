package se.kth.iv1350.processSale.model;

import java.util.List;

public class Payment {
    private Sale sale;
    private Money payedAmount;
    private List<RevenueObserver> revenueObservers;

    public Payment(Sale sale, List<RevenueObserver> observers) {
        this.sale = sale;
        this.payedAmount = new Money();
        this.revenueObservers = observers;
    }

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

    /*
     * Calculates change based on payment and total price
     */
    public Money getChange(){
        return calculateChange();
    }

    private Money calculateChange(){
        Money totalPrice = sale.getRunningTotalIncVAT();
        Money change = new Money(payedAmount);
        change.subtract(new Money(totalPrice));
        return change;
    }

    public SaleStateDTO getSaleState() {
        return sale.getSaleState();
    }

    public List<GroupedItem> getGroupedItemList() {
        return sale.getGroupedItemList();
    }

    public Money getPayedAmount() {
        return new Money(payedAmount);
    }

    public Money getRunningTotalIncVAT() {
        return sale.getRunningTotalIncVAT();
    }

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
