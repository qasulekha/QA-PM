package biz.promanage.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestLogger {
    public void log(String txt, String browser) {

        String msg = Thread.currentThread().getId() + Thread.currentThread().getStackTrace()[2].getClassName() + ":" + txt;
        System.out.println(msg);

        String strFile = "logs" + File.separator + browser
                + File.separator + DateUtils.GetCurrentDateAndTime();

        File logFile = new File(strFile);

        if (!logFile.exists()) {
            logFile.mkdirs();

        }

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(logFile + File.separator + "log.txt", true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.println(msg);
        printWriter.close();
    }

    public Logger log() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
    }
}
