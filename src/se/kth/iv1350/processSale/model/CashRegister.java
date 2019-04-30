package se.kth.iv1350.processSale.model;

public class CashRegister {

    private String registerID;
    private Cash cash;

    public CashRegister(String registerID) {
        cash = new Cash();
    }

    public void addCash(Cash amount) {
        cash.addCash(amount);
        System.out.println(cash);
    }

    public void withdrawCash(Cash amount) {
        cash.subtractCash(amount);
        System.out.println(cash);
    }

    public String getRegisterID() {
        return registerID;
    }

    public Cash getCash() {
        return cash;
    }
}
