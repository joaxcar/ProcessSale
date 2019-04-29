package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.Log;

public class Payment {

    private Sale sale;

    private boolean paymentMade;

    private Log log;

    private CashRegister cashRegister;

    public Payment(Sale sale, CashRegister cashRegister, Log log) {
        this.sale = sale;
        this.cashRegister = cashRegister;
        this.log = log;
        paymentMade = false;
    }

    public void makePayment(Amount payment) {

    }

    public void addDiscount(String customerID) {

    }

}
