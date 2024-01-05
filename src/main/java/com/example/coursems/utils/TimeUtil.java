package com.example.coursems.utils;

import com.example.coursems.cmd.ConstException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static final String DATE_TIME_FORMAT_SIMPLE = "dd/MM/yyyy hh:mm:ss";

    public static String formatDate (LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT_SIMPLE);
        return localDateTime.format(formatter);
    }

    public static long getTime(String time, String format) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            return dateFormat.parse(time).getTime();
        } catch (ParseException ex) {
            throw new Exception(ConstException.TIME_INVALID);
        }
    }
}
