package com.h3c.joda;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

/**
 * Created by LENOVO on 2017/6/7.
 */
public class JodaTest1 {
    public static void main(String[] args) {
        DateTime today = new DateTime();
        DateTime tomorrow = today.plusDays(1);
        System.out.println("today is : " + today.toString("yyyy-MM-dd"));
        System.out.println("tomorrow is : " + tomorrow.toString());
        DateTime d1 = today.withDayOfMonth(1);
        System.out.println(d1.toString("yyyy-MM-dd"));
        LocalDate localdate = new LocalDate();
        LocalDate date2 = localdate.minusYears(2).monthOfYear().setCopy(3).dayOfMonth().withMinimumValue();
        System.out.println(date2);

    }
}
