package se.kth.iv1350.processSale.util;

import java.io.IOException;

/**
 * Singleton class that handles logging for the application. Tries to log to a file and uses the console if the
 * attempt fails
 */
public class LogHandler implements Logger{
    private static final LogHandler LOG_HANDLER = new LogHandler();
    private Logger logger;

    /*
     * Private constructor for singleton object, tries to create a FileLogger, uses ConsoleLogger if fail
     */
    private LogHandler(){
        try {
            logger = new FileLogger();
        }
        catch (IOException ioe){
            System.out.println("Failed to initiate logfile, logging to console");
            ioe.printStackTrace();
            logger = new ConsoleLogger();
        }
    }

    /**
     * Get access to the singleton object of <code>LogHandler</code>
     *
     * @return <code>LogHandler</code> instance
     */
    public static LogHandler getLogHandler(){
        return LOG_HANDLER;
    }

    /**
     * Log information from <code>Exception</code>
     *
     * @param ex <code>Exception</code> to log
     */
    @Override
    public void logException(Exception ex) {
        logger.logException(ex);
    }

    /**
     * Log message
     *
     * @param msg message to log
     */
    @Override
    public void logMessage(String msg) {
        logger.logMessage(msg);
    }
}
