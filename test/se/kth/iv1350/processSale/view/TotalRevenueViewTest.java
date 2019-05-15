package se.kth.iv1350.processSale.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.processSale.model.Money;

class TotalRevenueViewTest {

    TotalRevenueView view;

    @BeforeEach
    void setup(){
        view = new TotalRevenueView();
    }

    @AfterEach
    void teardown(){
        view = null;
    }

    @Test
    void testNewPayment() {
        view.newPayment(new Money(300));
        String expPrint = "TotalRevenueView:: Total revenue: 300";

    }
}