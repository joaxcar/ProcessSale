package se.kth.iv1350.processSale.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class handles logging to a file
 */
public class FileLogger implements Logger {
    private static String FILE_NAME = "processController_logfile.txt";

    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    File logFile;

    /**
     * Create new instance of <code>Log</code>, removes old logfile and creates a new
     */
    public FileLogger() throws IOException{
        logFile = new File(FILE_NAME);
        if(logFile.exists()){
            logFile.delete();
        }
        logFile.createNewFile();
    }

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
     * Log information from <code>Exception</code>
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
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true));

            String logEntry = createTimeStamp() +
                    ": " +
                    type + " " +
                    message;
            writer.write(logEntry);
            writer.newLine();
            writer.flush();
            writer.close();
        }
        catch (IOException ioe){
            System.out.println("Failed to log exception: ");
            System.out.println(message);
            ioe.printStackTrace();
        }
    }
    private String createTimeStamp(){
        Date timeStamp = new Date();
        String dateString = formater.format(timeStamp.getTime());
        return dateString;
    }
}
