package se.kth.iv1350.processSale.model;

public final class VATRate {

    private static final double VAT_25 = 0.25;
    private static final double VAT_12 = 0.12;
    private static final double VAT_6 = 0.6;
    private static final double VAT_FREE = 0;

    private final double vatRate;

    public VATRate (){
        vatRate = VAT_25;
    }
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

    public double getRate(){
        return vatRate;
    }

}
