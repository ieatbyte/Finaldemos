package com.wh.finaldemos.demos.textshow.Date;

import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.TextView;

import com.wh.finaldemos.BaseDemoActivity;
import com.wh.finaldemos.R;

public class DateShowDemoActivity extends BaseDemoActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_show_demo);

        showIsToday(getTimeHourAgo(5));
        showIsYesterDay(getTimeHourAgo(24));
        showIsTheDayBeforeYesterday(getTimeHourAgo(49));
        showIsDate(getTimeDayAgo(3));
    }

    private long getTimeDayAgo(int day) {
        return System.currentTimeMillis() - day * 24 * 60 * 60 * 1000;
    }

    private long getTimeHourAgo(int hour) {
        return System.currentTimeMillis() - hour * 60 * 60 * 1000;
    }

    private long getTimeDayLater(int day) {
        return System.currentTimeMillis() + day * 24 * 60 * 60 * 1000;
    }

    private long getTimeHourLater(int hour) {
        return System.currentTimeMillis() + hour * 60 * 60 * 1000;
    }

    private void showIsToday(long time) {
        String isToday = DateUtils.isToday(time) ? "是今天" : "不是今天";
        getTextViewWithId(R.id.txt1).setText(isToday);
        //String relativeDay = DateUtils.getRelativeTimeSpanString(time, System.currentTimeMillis(), DateUtils.DAY_IN_MILLIS).toString();
        //getTextViewWithId(R.id.txt2).setText(relativeDay);
    }

    private void showIsYesterDay(long time) {
        String isToday = com.wh.finaldemos.demos.textshow.Date.DateUtils.getShortDay(time);
        getTextViewWithId(R.id.txt2).setText(isToday);
    }

    private void showIsTheDayBeforeYesterday(long time) {
        String isToday = com.wh.finaldemos.demos.textshow.Date.DateUtils.getShortDay(time);
        getTextViewWithId(R.id.txt3).setText(isToday);
        //String relativeDay = DateUtils.getRelativeTimeSpanString(time, System.currentTimeMillis(), DateUtils.DAY_IN_MILLIS).toString();
        //getTextViewWithId(R.id.txt2).setText(relativeDay);
    }

    private void showIsDate(long time) {
        String isToday = com.wh.finaldemos.demos.textshow.Date.DateUtils.getShortDay(time);
        getTextViewWithId(R.id.txt4).setText(isToday);
    }

    private TextView getTextViewWithId(int id) {
        return (TextView) findViewById(id);
    }
}
