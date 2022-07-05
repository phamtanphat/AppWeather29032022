package com.example.appweather29032022.common;

/**
 * Created by pphat on 7/5/2022.
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Support Convert to time
 */
public class TimeFormat {

    public static String convertMilliSecondToTime(long milliseconds) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        return formatter.format(calendar.getTime());
    }
}
