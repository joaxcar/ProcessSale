package se.kth.iv1350.processSale.model;

public class CashRegister {

    private String registerID;
    private Money money;

    public CashRegister(String registerID) {
        money = new Money();
        this.registerID = registerID;
    }

    public void addCash(Money amount) {
        money.add(amount);
    }

    public void withdrawCash(Money amount) {
        money.subtract(amount);
    }

    public String getRegisterID() {
        return registerID;
    }

    public Money getMoney() {
        return money;
    }
}
