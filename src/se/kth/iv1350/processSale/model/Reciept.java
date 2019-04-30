package se.kth.iv1350.processSale.model;
import java.util.Date;

public class Reciept {

    final SaleDTO sale;
    final Date date;
    final Cash payment;
    final Cash change;
    final String registerID;

    public Reciept(SaleDTO sale, Cash payment, Cash change, String registerID) {
        this.sale = sale;
        this.payment = payment;
        this.change = change;
        this.registerID = registerID;
        date = new Date();
    }
}
