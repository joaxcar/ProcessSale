package se.kth.iv1350.processSale.model;

/**
 * This class holds a VAT rate
 * VAT rates are stored as one of accepted values
 */
public final class VATRate {

    private static final double VAT_25 = 0.25;
    private static final double VAT_12 = 0.12;
    private static final double VAT_6 = 0.6;
    private static final double VAT_FREE = 0;

    private final double vatRate;

    /**
     * Create new instance of <code>VATRate</code>, set rate to highest
     */
    public VATRate (){
        vatRate = VAT_25;
    }

    /**
     * Create new instance of <code>VATRate</code>, set rate to given or highest
     * @param vatRate
     */
    public VATRate (int vatRate){
        if(vatRate == 25){
            this.vatRate = VAT_25;
        }
        else if(vatRate == 12){
            this.vatRate = VAT_12;
        }
        else if(vatRate == 6){
            this.vatRate = VAT_6;
        }
        else if(vatRate == 0){
            this.vatRate = VAT_FREE;
        }
        else {
            this.vatRate = VAT_25;
        }
    }

    /**
     * Returns VAT rate
     *
     * @return rate
     */
    public double getRate(){
        return vatRate;
    }
}
