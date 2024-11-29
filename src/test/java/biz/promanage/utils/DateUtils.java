package biz.promanage.utils;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateUtils {
    public static String GetDayOfTheWeek() {
        return new SimpleDateFormat("EEEE").format(new Date());
    }

    public static long GetTimeDifference() {
        String date = "";
        LocalDateTime now = LocalDateTime.now(Clock.systemUTC());
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        return ChronoUnit.SECONDS.between(now, dateTime);
    }
    public static String GetSimpleDate(String format) {
        Date dt = new Date();
        SimpleDateFormat dateFormat;
        dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(dt);
    }
    public static String GetCurrentDateAndTime() {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            return dtf.format(now);
        }
    }

