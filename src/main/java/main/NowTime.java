package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class NowTime {
    private static LocalDateTime time = LocalDateTime.now();
    private static DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("MM/dd (E) HH:mm:ss");

    public static LocalDateTime getNowLocalDateTime(){
        time = LocalDateTime.now();
        return time;
    }

    public static String getNowTime(){
        time = LocalDateTime.now();
        return time.format(timeFormat);
    }

    public static String getNowMonth(){
        time = LocalDateTime.now();
        return time.getMonth().getDisplayName(TextStyle.FULL,Locale.US);
    }
}
