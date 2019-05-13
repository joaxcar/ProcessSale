package se.kth.iv1350.processSale.util;

import java.io.IOException;

public class LogHandler implements Logger{
    private static final LogHandler LOG_HANDLER = new LogHandler();
    private Logger logger;

    private LogHandler(){
        try {
            logger = new FileLogger();
        }
        catch (IOException ioe){
            System.out.println("Failed to initiate logfile, logging to console");
            System.out.println(ioe.getStackTrace());
            logger = new ConsoleLogger();
        }
    }

    public static LogHandler getLogHandler(){
        return LOG_HANDLER;
    }

    @Override
    public void logException(Exception ex) {
        logger.logException(ex);
    }

    @Override
    public void logMessage(String msg) {
        logger.logMessage(msg);
    }
}
