package se.kth.iv1350.processSale.model;

import java.math.BigDecimal;

public class Money {

    private BigDecimal amount;

    public Money(String amount){
        this.amount = new BigDecimal(amount);
    }

    public Money(Money amount){
        this.amount = new BigDecimal(amount.toString());
    }

    public Money(double amount){
        this.amount = new BigDecimal(amount);
    }

    public Money(){
        amount = new BigDecimal("0");
    }

    @Override
    public String toString(){
        return amount.toString();
    }

    public void add(Money newMoney){
        amount = amount.add(new BigDecimal(newMoney.toString()));
    }

    public void subtract(Money newMoney){
        amount = amount.subtract(new BigDecimal(newMoney.toString()));
    }

    public boolean greaterThan(Money amount){
        int greaterThan = this.amount.compareTo(new BigDecimal(amount.toString()));
        if (greaterThan == 1){
            return true;
        }
        return false;
    }

}
