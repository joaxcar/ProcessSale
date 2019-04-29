package se.kth.iv1350.processSale.model;

public class Amount {

    private double amount;

    public Amount(double amount){
        this.amount=amount;
    }

    public Amount(Amount amount){
        this.amount=amount.getAmount();
    }

    public String toString(){
        return Double.toString(amount);
    }

    public double getAmount(){
        return amount;
    }

    public void addAmount(Amount newAmount){
        amount = amount + newAmount.getAmount();
    }

    public void multiplyAmount(int multiplier){
        amount = amount * multiplier;
    }

}
