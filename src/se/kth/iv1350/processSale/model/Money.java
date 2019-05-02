package se.kth.iv1350.processSale.model;

import java.math.BigDecimal;

/**
 * This class handles the concept of money. A <code>Money</code> object stores an amount representing the value of the
 * <code>Money</code> object
 */
public class Money {

    private BigDecimal amount;

    /**
     * Create new instance of <code>Money</code> from <code>String</code>
     *
     * @param amount value of <code>Money</code> object
     */
    public Money(String amount){
        this.amount = new BigDecimal(amount);
    }

    /**
     * Create a copy of <code>Money</code> object
     *
     * @param amount object to copy
     */
    public Money(Money amount){
        this.amount = new BigDecimal(amount.toString());
    }

    /**
     * Create new instance of <code>Money</code> from <code>double</code>
     *
     * @param amount value of <code>Money</code> object
     */
    public Money(double amount){
        this.amount = new BigDecimal(amount);
    }

    /**
     * Create default <code>Money</code> instance
     */
    public Money(){
        amount = new BigDecimal("0");
    }

    /**
     * Get value as a string
     *
     * @return value of <code>Money</code> as <code>String</code>
     */
    @Override
    public String toString(){
        return amount.toString();
    }

    /**
     * Add value of <code>Money</code> object to current object
     *
     * @param newMoney value to add
     */
    public void add(Money newMoney){
        amount = amount.add(new BigDecimal(newMoney.toString()));
    }

    /**
     * Subtract value of <code>Money</code> object to current object
     *
     * @param newMoney value to subtract
     */
    public void subtract(Money newMoney){
        amount = amount.subtract(new BigDecimal(newMoney.toString()));
    }

    /**
     * Compare value against other value
     *
     * @param amount value to compare against
     * @return true if greater than
     */
    public boolean greaterThan(Money amount){
        int greaterThan = this.amount.compareTo(new BigDecimal(amount.toString()));
        return greaterThan > 0;
    }
}
