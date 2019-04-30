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

    public void subtractAmount(Amount newAmount){
        amount = amount - newAmount.getAmount();
    }

    public void multiplyAmount(Amount multiplier){
        amount = amount * multiplier.getAmount();
    }

    public void multiplyAmount(double multiplier){
        amount = amount * multiplier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return Double.compare(amount1.amount, amount) == 0;
    }
}
