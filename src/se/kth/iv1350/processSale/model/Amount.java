package se.kth.iv1350.processSale.model;

public class Amount {

    private int amount;

    public Amount(int amount){
        this.amount=amount;
    }

    public String toString(){
        return Integer.toString(amount);
    }

    public int getAmount(){
        return amount;
    }

    public void addAmount(Amount newAmount){
        amount = amount + newAmount.getAmount();
    }

}
