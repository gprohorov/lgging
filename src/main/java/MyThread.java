/*
  @author   george
  @project   vsem4
  @class  MyThread
  @version  1.0.0 
  @since 12.04.2021 - 18.36
*/

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class MyThread extends Thread{
    private static final Logger logger = LogManager.getLogger();
     private LocalDate date;

    public MyThread(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public void run() {
        LocalDateTime start = LocalDateTime.now();
        logger.info( this + " has been started!");
        try {
            LogsService.getLogsCountByDate(this.getDate());
        } catch (IOException e) {
            e.printStackTrace();
        }
        LocalDateTime finish = LocalDateTime.now();
       // System.out.println(this.getName() + " has been finished at " + finish);
        logger.info( this + " has been finished.");
        System.out.println(this.getName() + " DURATION is  " +
                ChronoUnit.MILLIS.between(start, finish));

    }

}
