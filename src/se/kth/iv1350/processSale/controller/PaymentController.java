package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.AccountingSystem;
import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.integration.Log;
import se.kth.iv1350.processSale.integration.Printer;
import se.kth.iv1350.processSale.model.*;

public class PaymentController {

    private Sale sale;
    private AccountingSystem accountingSys;
    private CashRegister cashRegister;
    private Log log;
    private Money payment;
    private ItemRegistry itemReg;
    private Printer printer;

    /**
     * Create new instance
     *
     * @param accountingSys <code>Sale</code> related to the
     * @param cashRegister <code>CashRegister</code> to use for payment
     * @param log <code>Log</code> to use to log sale
     */
    public PaymentController(AccountingSystem accountingSys, CashRegister cashRegister, Log log, ItemRegistry itemReg, Printer printer) {
        this.accountingSys = accountingSys;
        this.cashRegister = cashRegister;
        this.log = log;
        this.itemReg = itemReg;
        this.printer = printer;
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

    /**
     * End current payment if payment is done. Update systems and print reciept
     */
    public void endPayment(){
        if(checkPaymentDone()){
            Reciept reciept = new Reciept(sale, payment, calculateChange(), cashRegister.getRegisterID());
            cashRegister.addCash(payment);
            cashRegister.withdrawCash(calculateChange());
            accountingSys.makeEntry(reciept);
            log.logEntry(sale);
            itemReg.updateInventory(sale);
            printer.printReciept(reciept);
            sale = null;
        }
    }

    /**
     * Returns <code>Sale</code> related to payment
     *
     * @return <code>Sale</code> related to payment
     */
    public SaleDTO getSale(){
        return sale;
    }

    public String getAmountPayed(){
        return payment.toString();
    }

    public String getChange(){
        return calculateChange().toString();
    }

    private Money calculateChange(){
        double totalPrice = sale.getRunningTotalIncVAT();
        Money change = new Money(payment);
        change.subtract(new Money(Double.toString(totalPrice)));
        return change;
    }

}
