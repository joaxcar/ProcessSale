package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.AccountingSystem;
import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.integration.Log;
import se.kth.iv1350.processSale.model.*;

public class PaymentController {

    private Sale sale;
    private Reciept reciept;
    private AccountingSystem accountingSys;
    private CashRegister cashRegister;
    private Log log;
    private boolean paymentDone;
    private Cash payment;
    private ItemRegistry itemReg;

    /**
     * Create new instance
     *
     * @param accountingSys <code>Sale</code> related to the
     * @param cashRegister <code>CashRegister</code> to use for payment
     * @param log <code>Log</code> to use to log sale
     */
    public PaymentController(AccountingSystem accountingSys, CashRegister cashRegister, Log log, ItemRegistry itemReg) {
        this.accountingSys = accountingSys;
        this.cashRegister = cashRegister;
        this.log = log;
        this.itemReg = itemReg;
    }

    //public Amount pay(Amount paidAmt) {
        //currentPayment.makePayment(paidAmt);
        //Amount change = currentPayment.getChange();
//
        //if (currentPayment.checkPaymentDone()){
            //currentPayment.endPayment();
            //accountingSys.makeEntry(currentPayment);
            //itemReg.updateInventory(currentPayment);
            //currentPayment = null;
        //}
//
        //return change;
    //}

    public void initializePayment(Sale sale) {
        this.sale = sale;
    }

    public void makePayment(Cash payment) {
        payment.addCash(payment);
        if (payment.getAmount() > getTotalPriceIncVAT()){
            paymentDone = true;
        }
    }

    public boolean checkPaymentDone(){
        return paymentDone;
    }


    /**
     * Returns <code>Sale</code> related to
     *
     * @return <code>Sale</code> related to
     */
    public SaleDTO getSale(){
        return sale;
    }

    public double getTotalPriceIncVAT() {
        return sale.getRunningTotalIncVAT();
    }


    public double getAmountPayed(){
        return payment.getAmount();
    }

    public Cash getChange(){
        Cash change = new Cash(sale.getRunningTotalIncVAT() - payment.getAmount());
        return change;
    }

    public void endPayment(){
        if(paymentDone){
            reciept = new Reciept(sale, payment, getChange(), cashRegister.getRegisterID());
            cashRegister.addCash(payment);
            cashRegister.withdrawCash(getChange());
        }
    }
}
