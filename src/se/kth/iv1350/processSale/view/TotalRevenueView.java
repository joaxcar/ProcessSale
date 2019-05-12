package se.kth.iv1350.processSale.view;

import se.kth.iv1350.processSale.model.Money;
import se.kth.iv1350.processSale.model.RevenueObserver;

import java.util.ArrayList;
import java.util.List;

public class TotalRevenueView implements RevenueObserver {
    private List<Money> revenue = new ArrayList<Money>();

    @Override
    public void newPayment(Money revenue){
        this.revenue.add(revenue);
        printTotalRevenue();
    }

    private void printTotalRevenue() {
        Money totalRevenue = new Money();
        for (Money payment : revenue){
            totalRevenue.add(payment);
        }
        System.out.println("TotalRevenueView:: Total revenue: " + totalRevenue);
    }
}
