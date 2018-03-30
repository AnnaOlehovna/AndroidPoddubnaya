package com.olehovnagmail.anya.domain.homework6.convertDate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertDateToString {
    public String convertDateToString(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss", Locale.ENGLISH);
        return sdf.format(date);
    }
}
