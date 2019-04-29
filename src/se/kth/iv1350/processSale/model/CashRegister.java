package se.kth.iv1350.processSale.model;

public class CashRegister {

    private Amount cash;

    public CashRegister() {
        cash = new Amount(0);
    }

    public void addCash(Amount amount) {
        cash.addAmount(amount);
        System.out.println(cash);
    }

    public void withdrawCash(Amount amount) {
        cash.subtractAmount(amount);
        System.out.println(cash);
    }
}
