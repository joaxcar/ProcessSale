package se.kth.iv1350.processSale.controller;

import se.kth.iv1350.processSale.integration.AccountingSystem;
import se.kth.iv1350.processSale.integration.ItemRegistry;
import se.kth.iv1350.processSale.integration.Log;
import se.kth.iv1350.processSale.model.Cash;
import se.kth.iv1350.processSale.model.CashRegister;
import se.kth.iv1350.processSale.model.Sale;
import se.kth.iv1350.processSale.model.SaleDTO;

public class PaymentController {

    private Sale sale;
    private AccountingSystem accountingSys;
    private CashRegister cashRegister;
    private Log log;
    private boolean paymentDone;
    private Cash amountPayed;
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

    //public void makePayment(Cash payment) {
        //amountPayed.addAmount(payment);
////
        //if (amountPayed.getAmount() > sale.getRunningTotalIncVAT().getAmount()){
            //paymentDone = true;
        //}
    //}

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


    //  public Amount getAmountPayed(){
        //return new Amount(amountPayed);
    //}
//
    //public Amount getChange(){
        //Amount change = new Amount(amountPayed);
        //change.subtractAmount(sale.getRunningTotalIncVAT());
        //return change;
    //}
//
    ////public void endPayment(){
        //log.logEntry(sale);
        //cashRegister.addCash(amountPayed);
        //cashRegister.withdrawCash(getChange());

    //}
}
