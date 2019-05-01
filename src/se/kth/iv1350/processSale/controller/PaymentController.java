package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.ExternalSystems;
import se.kth.iv1350.processSale.integration.Printer;
import se.kth.iv1350.processSale.model.CashRegister;
import se.kth.iv1350.processSale.model.Money;
import se.kth.iv1350.processSale.model.RecieptDTO;
import se.kth.iv1350.processSale.model.Sale;

public class PaymentController {

    private final CashRegister cashRegister;
    private Printer printer;
    private ExternalSystems extSys;
    private Money payment;
    private Sale sale;

    public PaymentController(CashRegister cashRegister, ExternalSystems extSys, Printer printer){
        this.cashRegister = cashRegister;
        this.printer = printer;
        this.extSys = extSys;
        payment = new Money("0");
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
     * Add amount to <code>Payment</code>
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

    public String getChange(){
        return calculateChange().toString();
    }

    private Money calculateChange(){
        Money totalPrice = sale.getRunningTotalIncVAT();
        Money change = new Money(payment);
        change.subtract(new Money(totalPrice));
        return change;
    }

    public Money getTotalPriceIncVAT() {
        return sale.getRunningTotalIncVAT();
    }

    /**
     * End current payment if payment is done. Update systems and print reciept
     */
    public void endPayment(){
        if(checkPaymentDone()){
            updateCashRegister();
            updateExternalSystems();
            printReciept();
            sale = null;
        }
    }

    private void updateExternalSystems() {
        extSys.makeEntry(sale, makeReciept());
    }

    private void printReciept(){
        printer.printReciept(makeReciept());
    }
    private RecieptDTO makeReciept(){
        return new RecieptDTO(sale, payment, calculateChange(), cashRegister);
    }

    private void updateCashRegister(){
        cashRegister.addCash(payment);
        cashRegister.withdrawCash(calculateChange());
    }

}
