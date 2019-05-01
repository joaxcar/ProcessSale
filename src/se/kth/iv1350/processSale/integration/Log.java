package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Sale;

public class Log {

    public Log() {
    }

    public void logEntry(Sale saleToLog) {
        System.out.println("Making log entry for sale");
    }

}
