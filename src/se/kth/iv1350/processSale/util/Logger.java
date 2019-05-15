package se.kth.iv1350.processSale.util;

/**
 * Interface to be implemented by all classes that do logging
 */
public interface Logger {

    /**
     * Log message
     *
     * @param msg message to log
     */
    void logMessage(String msg);

    /**
     * Log information from <code>Exception</code>
     * @param ex <code>Exception</code> to log
     */
    void logException(Exception ex);
}
