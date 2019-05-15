package se.kth.iv1350.processSale.model;

/**
 * Interface to be implemented when a class need updates about the total revenue during the runtime of the program.
 */
public interface RevenueObserver {

    /**
     * Invoked when a payment has been made
     *
     * @param revenue revenue from sale
     */
    void newPayment(Money revenue);
}
