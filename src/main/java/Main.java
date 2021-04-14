/*
  @author   george
  @project   lgging
  @class  Main
  @version  1.0.0 
  @since 14.04.2021 - 08.41
*/

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(" ---------------------   Threads -----------------");


        LocalDateTime start = LocalDateTime.now();


        LocalDate date = LocalDate.of(2020, Month.FEBRUARY, 10);



        for (int i = 0; i < 5; i++) {
            // System.out.print(date.plusDays(i) + " - ");
            LogsService.getLogsCountByDate(date.plusDays(i));
        }



        LocalDateTime finish = LocalDateTime.now();

        System.out.println(ChronoUnit.MILLIS.between(start, finish) + " msec");
        System.out.println("------------------   threads ---------------");

        start = LocalDateTime.now();
        for (int i = 0; i < 5; i++) {
            new MyThread(date.plusDays(i)).start();
        }

    }


}
