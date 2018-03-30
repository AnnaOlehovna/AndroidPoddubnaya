package com.olehovnagmail.anya.data.homework6.convertData;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertDate {
       /**
     * Convert date from String format to class Date according to the pattern
     *
     * @param dateInString String date
     * @return class Date
     */
    public Date convertStringtoDate(String dateInString) {
        Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
            try {
                date = sdf.parse(dateInString);
            } catch (ParseException e) {}

        return date;
    }

}
