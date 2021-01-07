package com.app.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckWeekEnd {
    /*
     * @Author Karunakar
     * 
     * Date: 2020-12-05
     */
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("");
        LocalDateTime d1 = LocalDateTime.of(2020, 12, 6, 13, 21, 21);
        System.out.println(d1);
        LocalDateTime d = LocalDateTime.now();
        System.out.println(d.getHour());
        new CheckWeekEnd().checkGivenDayisWeekEndOrNot(d);
    }

    public void checkGivenDayisWeekEndOrNot(LocalDateTime day) {
        if (day.getDayOfWeek().name().equals("SATURDAY"))
            System.out.println(day.getDayOfWeek() + " is Week end");
        else
            System.out.println(day.getDayOfWeek() + " is not Week end");

    }
}
