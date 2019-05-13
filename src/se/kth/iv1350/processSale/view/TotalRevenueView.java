package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.model.Money;
import se.kth.iv1350.processSale.model.RevenueObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * View implementing the <code>RevenueObserver</code> interface. Responsible of presenting a running count of the
 * revenue from program start
 */
public class TotalRevenueView implements RevenueObserver {
    private List<Money> revenue = new ArrayList<Money>();

    /**
     * Method to be called by observed class when new payment have been made
     *
     * @param revenue payment minus change
     */
    @Override
    public void newPayment(Money revenue){
        this.revenue.add(revenue);
        printTotalRevenue();
    }

    /*
     * Sum and print list of payments
     */
    private void printTotalRevenue() {
        Money totalRevenue = new Money();
        for (Money payment : revenue){
            totalRevenue.add(payment);
        }
        System.out.println("TotalRevenueView:: Total revenue: " + totalRevenue);
    }
}
