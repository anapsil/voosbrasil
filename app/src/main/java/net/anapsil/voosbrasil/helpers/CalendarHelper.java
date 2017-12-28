package net.anapsil.voosbrasil.helpers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SHORT;
import static java.util.Calendar.YEAR;

public class CalendarHelper {
    public static final String PATTERN_DATE = "dd/MM/yyyy";

    private Locale defaultLocale;

    public CalendarHelper(Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    public Calendar getToday() {
        return Calendar.getInstance(defaultLocale);
    }

    public Locale getDefaultLocale() {
        return defaultLocale;
    }

    public String formatDate(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE, defaultLocale);

        return sdf.format(calendar.getTime());
    }

    public String formatFulldate(Calendar calendar) {
        StringBuilder sb = new StringBuilder();
        sb.append(calendar.getDisplayName(DAY_OF_WEEK, SHORT, defaultLocale))
                .append(", ");
        if (calendar.get(DAY_OF_MONTH) < 10) {
            sb.append("0")
                    .append(calendar.get(DAY_OF_MONTH));
        } else {
            sb.append(calendar.get(DAY_OF_MONTH));
        }
        sb.append(" de ")
                .append(calendar.getDisplayName(MONTH, SHORT, defaultLocale))
                .append(" de ")
                .append(calendar.get(YEAR));

        return sb.toString();
    }

    public String formatTime(Calendar calendar) {
        StringBuilder sb = new StringBuilder();
        if (calendar.get(Calendar.HOUR_OF_DAY) < 10) {
            sb.append("0")
                    .append(calendar.get(Calendar.HOUR_OF_DAY));
        } else {
            sb.append(calendar.get(Calendar.HOUR_OF_DAY));
        }

        sb.append(":");

        if (calendar.get(Calendar.MINUTE) < 10) {
            sb.append("0")
                    .append(calendar.get(Calendar.MINUTE));
        } else {
            sb.append(calendar.get(Calendar.MINUTE));
        }

        return sb.toString();
    }
}
