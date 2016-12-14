package com.whlib.testjavalib.simpletrys;

import com.whlib.testjavalib.ABaseTry;
import com.whlib.testjavalib.Loger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by wanghui on 16-11-25.
 */

public class CalendarSimpleDateFormatTry extends ABaseTry{

    @Override
    public void startTry() {
        super.startTry();

        Calendar calendar = Calendar.getInstance();
        Loger.d("CalendarSimpleDateFormatTry tz1:" + calendar.getTimeZone().getDisplayName());
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+03:00"));
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date date = calendar.getTime();
        Loger.d("CalendarSimpleDateFormatTry tz2:" + calendar.getTimeZone().getDisplayName());
        Loger.d("CalendarSimpleDateFormatTry " + date);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.GERMANY);
        //df.setTimeZone();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        df.setCalendar(calendar);
        Loger.d("CalendarSimpleDateFormatTry after format:" + df.format(date));
    }
}
