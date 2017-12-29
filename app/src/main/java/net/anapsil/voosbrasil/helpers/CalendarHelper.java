package net.anapsil.voosbrasil.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.MONTH;

public class CalendarHelper {
    public static final String DEFAULT_PATTERN_DATE = "dd/MM/yyyy";
    public static final String PATTERN_YYYYMMDD = "yyyyMMdd";
    public static final String PATTERN_YYYY_MM_DD_t_HH_MM = "yyyy-MM-dd't'HHmm";

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
        return formatDate(calendar, DEFAULT_PATTERN_DATE);
    }

    public String formatDate(Calendar calendar, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, defaultLocale);

        return sdf.format(calendar.getTime());
    }

    public String formatDate(String date, String patternSource, String patternTarget) {
        Calendar calendar = parseDate(date, patternSource);

        return formatDate(calendar, patternTarget);
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

    public Calendar parseDate(String date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, defaultLocale);

        try {
            Date parsedDate = sdf.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(parsedDate);

            return calendar;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String formatFullDate(Calendar calendar) {
        StringBuilder sb = new StringBuilder();
        sb.append(calendar.getDisplayName(DAY_OF_WEEK, Calendar.LONG, defaultLocale))
                .append(", ");
        if (calendar.get(DAY_OF_MONTH) < 10) {
            sb.append("0")
                    .append(calendar.get(DAY_OF_MONTH));
        } else {
            sb.append(calendar.get(DAY_OF_MONTH));
        }
        sb.append(" de ")
                .append(calendar.getDisplayName(MONTH, Calendar.LONG, defaultLocale));

        return sb.toString();
    }

    public String formatFullDate(String date, String pattern) {
        return formatFullDate(parseDate(date, pattern));
    }
}
