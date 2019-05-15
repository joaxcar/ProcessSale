package se.kth.iv1350.processSale.model;

/**
 * Decorator of <code>Sale</code> that subtracts an amount from the total price
 */
public class SaleDiscount extends SaleDecorator {

    /**
     * Creates new instance of <code>SaleDiscount</code> as a decorator to given <code>Sale</code>
     *
     * @param sale <code>Sale</code> to decorate
     */
    public SaleDiscount(Sale sale){
        super(sale);
    }

    /**
     * Returns current total price with discount
     *
     * @return current total price
     */
    @Override
    public Money getRunningTotalIncVAT(){
        Money totalIncDiscout = new Money(sale.getRunningTotalIncVAT());
        totalIncDiscout.subtract(new Money(1000));
        return totalIncDiscout;
    }
}
