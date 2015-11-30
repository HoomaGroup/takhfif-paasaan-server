package ir.paasaan.util;

import java.util.*;

/**
 * @author arman
 * @since 11/30/2015.
 */
public class DateConverter {

    public static Date convertToGregorianDate(String jalaliDate,String Time){
        int year = Integer.parseInt(jalaliDate.substring(0, 4));
        int month = Integer.parseInt(jalaliDate.substring(4, 6))-1;
        int day = Integer.parseInt(jalaliDate.substring(6, 8));

        int hour = Integer.parseInt(Time.substring(0, 2));
        int minute = Integer.parseInt(Time.substring(2, 4));
        int second = Integer.parseInt(Time.substring(4, 6));

        JalaliCalendar jalaliCalendar = new JalaliCalendar(year, month, day, hour, minute,second);
        jalaliCalendar.setTimeZone(TimeZone.getTimeZone("IRST"));
        return jalaliCalendar.getTime();
    }

    public static String convertToJalaliDate(Date date){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        JalaliCalendar.YearMonthDate yearMonthDate =
                JalaliCalendar.gregorianToJalali(new JalaliCalendar.YearMonthDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)));
        String month = String.valueOf(yearMonthDate.getMonth() + 1);
        if(yearMonthDate.getMonth() + 1 <= 9){
            month = "0"+ month;
        }
        String day = String.valueOf(yearMonthDate.getDate());
        if(yearMonthDate.getDate() <= 9) {
            day = "0" + day;
        }
        return String.valueOf(yearMonthDate.getYear()) + month + day;
    }
    public static void main(String[] args) {
        Date date = convertToGregorianDate("13940909", "135601");
        System.out.println( convertToJalaliDate(new Date()));
        System.out.println(date);
    }
}
