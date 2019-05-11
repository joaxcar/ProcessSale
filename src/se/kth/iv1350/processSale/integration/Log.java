package se.kth.iv1350.processSale.integration;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class handles logging to a file
 */
public class Log {
    private static String FILE_NAME = "processController_logfile.txt";

    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
    File logFile;

    /**
     * Create new instance of <code>Log</code>, removes old logfile and creates a new
     */
    public Log() throws IOException{
        logFile = new File(FILE_NAME);
        if(logFile.exists()){
            logFile.delete();
        }
        logFile.createNewFile();
    }

    /**
     * Log information from sale in external log system
     *
     * @param message message to log
     */
    public void logEntry(String message) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(logFile,true));
        Date timeStamp = new Date();
        String dateString = formater.format(timeStamp.getTime());

        StringBuilder logEntry = new StringBuilder();
        logEntry.append(dateString);
        logEntry.append(": ");
        logEntry.append(message);

        writer.write(logEntry.toString());
        writer.newLine();
        writer.flush();
        writer.close();
    }
}
