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
    private ExternalSystems extSys;
    private List<RevenueObserver> revenueObservers = new ArrayList<RevenueObserver>();
    private Payment payment;

    /**
     * Creates new intance of <code>PaymentController</code>
     * @param extSys <code>ExternalSystems</code> to be used by the controller
     */
    public PaymentController(ExternalSystems extSys){
        this.extSys = extSys;
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
    void initializePayment(Sale sale) {
        this.payment = new Payment(sale);
    }

    /**
     * Add amount to payment, converts from <code>String</code> to <code>Money</code>
     *
     * @param amount Amount to be added
     */
    public void makePayment(String amount) {
        payment.add(new Money(amount));
    }

    /**
     * Returns change as a <code>String</code>
     *
     * @return <code>String</code> of amount
     */
    public String getChange(){
        Money change = payment.getChange();
        return change.toString();
    }



    /**
     * Returns final state of the sale being handled
     *
     * @return <code>SaleStateDTO</code> from sale
     */
    public SaleStateDTO getFinalSaleState(){
        return payment.getSaleState();
    }

    /**
     * End current payment if payment is done. Update systems and print reciept
     */
    public void endPayment(){
        if(payment.checkPaymentDone()){
            updateCashRegister();
            updateExternalSystems();
            printReciept();
            notifyObservers();
            payment = null;
        }
    }

    /*
     * Notify all observers of new payment
     */
    private void notifyObservers() {
        Money revenue = payment.getPayedAmount();
        Money change = payment.getChange();
        revenue.subtract(change);
        for (RevenueObserver observer : revenueObservers){
            observer.newPayment(revenue);
        }
    }

    /*
     * private helper functions for connection with external systems
     */
    private void updateExternalSystems() {
        extSys.makeEntry(payment.getGroupedItemList(), makeReciept());
    }

    private void printReciept(){
        Printer.getPrinter().print(makeReciept().toString());
    }

    private ReceiptDTO makeReciept(){
        return new ReceiptDTO(payment);
    }

    private void updateCashRegister(){
        CashRegister cashReg = CashRegister.getCashRegister();
        cashReg.addCash(payment.getPayedAmount());
        cashReg.withdrawCash(payment.getChange());
    }
}
