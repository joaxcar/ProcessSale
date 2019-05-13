package se.kth.iv1350.processSale.integration;

public interface Logger {
    void logException(Exception ex);
    void logMessage(String msg);
}
