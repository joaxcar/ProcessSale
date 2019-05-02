package se.kth.iv1350.processSale.model;

/**
 * This class represents a cash register. A cash register holds information of its ID and the total amount of money
 * present in the register
 */
public class CashRegister {

    private final String registerID;
    private final Money money;

    /**
     * Create new instance of <code>CashRegister</code>
     *
     * @param registerID <code>String</code> to use as register ID
     */
    public CashRegister(String registerID) {
        money = new Money();
        this.registerID = registerID;
    }

    /**
     * Add an amount of money to the cash register
     *
     * @param amount <code>Money</code> to add
     */
    public void addCash(Money amount) {
        money.add(amount);
    }

    /**
     * Withdraw an amount of money from the cash register
     *
     * @param amount <code>Money</code> to withdraw
     */
    public void withdrawCash(Money amount) {
        money.subtract(amount);
    }

    /**
     * Get cash registers ID
     *
     * @return <code>String</code> with ID
     */
    public String getRegisterID() {
        return registerID;
    }

    /**
     * Get amount of money present in cash register
     *
     * @return <code>Money</code> containing copy of amount in register
     */
    public Money getMoney() {
        return new Money(money);
    }
}
