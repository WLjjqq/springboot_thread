package com.springboot_thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateFormat {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            Date parse = sdf.parse("2019-03-26T04:20:18.619Z");
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        String format = sdf.format(date);
        System.out.printf(format);
    }
}
