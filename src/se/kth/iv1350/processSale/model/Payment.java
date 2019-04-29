package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.CustomerDTO;

public class Payment {

    private Sale sale;

    private boolean paymentMade;

    private CustomerDTO customer;

    private Logger logger;

    private Discount discount;

    private CashRegister cashRegister;

    public Payment Payment(Sale activeSale) {
        return null;
    }

    public void makePayment(Amount payment) {

    }

    public void addDiscount(String customerID) {

    }

}
