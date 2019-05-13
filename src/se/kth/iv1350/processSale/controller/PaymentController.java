package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.ExternalSystems;
import se.kth.iv1350.processSale.integration.Printer;
import se.kth.iv1350.processSale.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class handles requests from view classes concerning payments. To make payments a <code>Sale</code> object needs
 * to be provided
 */
public class PaymentController {
    private CashRegister cashRegister;
    private ExternalSystems extSys;
    private Money payment;
    private Sale sale;
    private List<RevenueObserver> revenueObservers = new ArrayList<RevenueObserver>();

    /**
     * Creates new intance of <code>PaymentController</code>
     * @param cashRegister <code>CashRegister</code> to be used by the controller
     * @param extSys <code>ExternalSystems</code> to be used by the controller
     */
    public PaymentController(CashRegister cashRegister, ExternalSystems extSys){
        this.cashRegister = cashRegister;
        this.extSys = extSys;
        payment = new Money();
    }

    /**
     * Add an observer to the observer list to be ;notified when payments are made
     *
     * @param observer object to notify
     */
    public void addObserver(RevenueObserver observer){
        revenueObservers.add(observer);
    }

    /**
     * Starts a new <code>Payment</code> instance for <code>Sale</code> object
     *
     * @param sale <code>Sale</code> object to connect to <code>Payment</code>
     */
    public void initializePayment(Sale sale) {
        this.sale = sale;
    }

    /**
     * Add amount to payment, converts from <code>String</code> to <code>Money</code>
     *
     * @param payment Amount to be added
     */
    public void makePayment(String payment) {
        this.payment.add(new Money(payment));
    }

    /**
     * Check if amount payed is greater or equals the total price of the <code>Sale</code>
     *
     * @return <code>true</code> if amount is greater or equal to total price
     */
    public boolean checkPaymentDone(){
        boolean paymentDone = payment.greaterThan(new Money(sale.getRunningTotalIncVAT()));
        return paymentDone;
    }

    /**
     * Returns change as a <code>String</code>
     *
     * @return <code>String</code> of amount
     */
    public String getChange(){
        return calculateChange().toString();
    }

    /*
     * Calculates change based on payment and total price
     */
    private Money calculateChange(){
        Money totalPrice = sale.getRunningTotalIncVAT();
        Money change = new Money(payment);
        change.subtract(new Money(totalPrice));
        return change;
    }

    /**
     * Returns final state of the sale being handled
     *
     * @return <code>SaleStateDTO</code> from sale
     */
    public SaleStateDTO getFinalSaleState(){
        return sale.getSaleState();
    }

    /**
     * End current payment if payment is done. Update systems and print reciept
     */
    public void endPayment(){
        if(checkPaymentDone()){
            updateCashRegister();
            updateExternalSystems();
            printReciept();
            notifyObservers();
            sale = null;
        }
    }

    /*
     * Notify all observers of new payment
     */
    private void notifyObservers() {
        Money revenue = new Money(payment);
        Money change = calculateChange();
        revenue.subtract(change);
        for (RevenueObserver observer : revenueObservers){
            observer.newPayment(revenue);
        }
    }

    /*
     * private helper functions for connection with external systems
     */
    private void updateExternalSystems() {
        extSys.makeEntry(sale, makeReciept());
    }

    private void printReciept(){
        Printer.getPrinter().print(makeReciept().toString());
    }

    private ReceiptDTO makeReciept(){
        return new ReceiptDTO(sale, payment, calculateChange(), cashRegister);
    }

    private void updateCashRegister(){
        cashRegister.addCash(payment);
        cashRegister.withdrawCash(calculateChange());
    }
}
