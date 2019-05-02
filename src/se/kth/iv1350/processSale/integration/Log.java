package se.kth.iv1350.processSale.integration;

import se.kth.iv1350.processSale.model.Sale;

/**
 * This class handles logging to an external log system
 */
public class Log {

    /**
     * Create new instance of <code>Log</code>
     */
    public Log() {}

    /**
     * Log information from sale in external log system
     *
     * @param saleToLog <code>Sale</code> object to log
     */
    public void logEntry(Sale saleToLog) {
        System.out.println("Making log entry for sale");
    }
}
