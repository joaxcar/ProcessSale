package se.kth.iv1350.processSale.model;

public class SaleDiscount extends SaleDecorator {

    public SaleDiscount(Sale sale){
        super(sale);
    }

    @Override
    public Money getRunningTotalIncVAT(){
        Money totalIncDiscout = new Money(sale.getRunningTotalIncVAT());
        totalIncDiscout.subtract(new Money(1000));
        return totalIncDiscout;
    }
}
