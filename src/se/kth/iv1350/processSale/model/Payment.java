package se.kth.iv1350.processSale.model;

import se.kth.iv1350.processSale.integration.Log;

public class Payment {

    private Sale sale;

    private boolean paymentDone;

    private Log log;

    private CashRegister cashRegister;

    private Amount amountPayed;


    /**
     * Create new instance
     *
     * @param sale <code>Sale</code> related to the <code>Payment</code>
     * @param cashRegister <code>CashRegister</code> to use for payment
     * @param log <code>Log</code> to use to log sale
     */
    public Payment(Sale sale, CashRegister cashRegister, Log log) {
        this.sale = sale;
        this.cashRegister = cashRegister;
        this.log = log;
        amountPayed = new Amount(0);
        paymentDone = false;
    }

    /**
     * Add amount to <code>Payment</code>
     *
     * @param payment <code>Amount</code> to add to <code>Payment</code>
     */
    public void makePayment(Amount payment) {
        amountPayed.addAmount(payment);

        if (amountPayed.getAmount() > sale.getRunningTotalIncVAT().getAmount()){
            paymentDone = true;
        }
    }

    public boolean checkPaymentDone(){
        return paymentDone;
    }


    /**
     * Returns <code>Sale</code> related to <code>Payment</code>
     *
     * @return <code>Sale</code> related to <code>Payment</code>
     */
    public Sale getSale(){
        return sale;
    }


    public Amount getAmountPayed(){
        return new Amount(amountPayed);
    }

    public Amount getChange(){
        Amount change = new Amount(amountPayed);
        change.subtractAmount(sale.getRunningTotalIncVAT());
        return change;
    }

    public void endPayment(){
        log.logEntry(sale);
        cashRegister.addCash(amountPayed);
        cashRegister.withdrawCash(getChange());

    }
}
