package se.kth.iv1350.processSale.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LogTest {

    Log testLog;

    @BeforeEach
    void setup() throws IOException{
        testLog = new Log();
    }
    @AfterEach
    void teardown(){
        testLog = null;
    }

    @Test
    void testOneLogEntry() throws IOException{
        testLog.logEntry("test");
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formater.format(date.getTime());
        BufferedReader reader = new BufferedReader(new FileReader("processController_logfile.txt"));
        String line = reader.readLine();
        assertEquals(line, dateString + ": test", "wrong logmessage in file");
    }

    @Test
    void testMultipleLogEntries() throws IOException{
        testLog.logEntry("test1");
        testLog.logEntry("test2");
        Date date = new Date();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formater.format(date.getTime());
        BufferedReader reader = new BufferedReader(new FileReader("processController_logfile.txt"));
        String line1 = reader.readLine();
        String line2 = reader.readLine();
        assertEquals(line1, dateString + ": test1");
        assertEquals(line2, dateString + ": test2");
    }
}