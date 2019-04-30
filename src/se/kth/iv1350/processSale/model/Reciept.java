package se.kth.iv1350.processSale.model;
import java.util.Date;

public class Reciept {

    public final SaleDTO sale;
    public final Date date;
    public final Money payment;
    public final Money change;
    public final String registerID;

    public Reciept(SaleDTO sale, Money payment, Money change, String registerID) {
        this.sale = sale;
        this.payment = payment;
        this.change = change;
        this.registerID = registerID;
        date = new Date();
    }
}
