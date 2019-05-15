package se.kth.iv1350.processSale.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class handles logging to the console
 */
public class ConsoleLogger implements Logger {

    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Log message
     *
     * @param message message to log
     */
    @Override
    public void logMessage(String message) {
        logEntry("MESSAGE", message);
    }

    /**
     * Log information from an exception
     *
     * @param ex exception to log
     */
    @Override
    public void logException(Exception ex) {
        logEntry("EXCEPTION", ex.getMessage());
    }

    /*
     * Write message to the log file
     */
    private void logEntry(String type, String message){
        StringBuilder logEntry = new StringBuilder();

        logEntry.append(createTimeStamp());
        logEntry.append(": ");
        logEntry.append(type + " ");
        logEntry.append(message);

        System.out.println(logEntry);
    }

    private String createTimeStamp(){
        Date timeStamp = new Date();
        String dateString = formater.format(timeStamp.getTime());
        return dateString;
    }
}
