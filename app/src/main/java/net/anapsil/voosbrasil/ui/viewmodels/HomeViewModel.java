package net.anapsil.voosbrasil.ui.viewmodels;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.databinding.ObservableInt;
import android.view.View;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import net.anapsil.voosbrasil.R;
import net.anapsil.voosbrasil.helpers.CalendarHelper;
import net.anapsil.voosbrasil.ui.databinding.ObservableString;

import java.util.Calendar;

import javax.inject.Inject;
import javax.inject.Named;

public class HomeViewModel extends RxBaseViewModel implements DatePickerDialog.OnDateSetListener {
    private final String TAG_DEPARTURE = "departure";
    private final String TAG_ARRIVAL = "arrival";
    private final String ACTION_FLIGHT_SEARCH = "net.anapsil.voosbrasil.FLIGHT_SEARCH";

    public ObservableString source = new ObservableString();
    public ObservableString destination = new ObservableString();
    public ObservableString departure = new ObservableString();
    public ObservableString arrival = new ObservableString();
    public ObservableInt adults = new ObservableInt(1);

    private DatePickerDialog datePickerDialog;
    private Activity activity;
    private FragmentManager fragmentManager;
    private Resources resources;
    private CalendarHelper calendarHelper;

    @Inject
    public HomeViewModel(@Named("home") Activity activity, FragmentManager fragmentManager, Resources resources, CalendarHelper calendarHelper) {
        this.activity = activity;
        this.fragmentManager = fragmentManager;
        this.resources = resources;
        this.calendarHelper = calendarHelper;

        departure.set(resources.getString(R.string.departure_date));
        arrival.set(resources.getString(R.string.arrival_date));

        datePickerDialog = DatePickerDialog.newInstance(this,
                calendarHelper.getToday().get(Calendar.YEAR),
                calendarHelper.getToday().get(Calendar.MONTH),
                calendarHelper.getToday().get(Calendar.DAY_OF_MONTH));

        datePickerDialog.setLocale(calendarHelper.getDefaultLocale());
    }

    public void onDepartureClick(View v) {
        datePickerDialog.show(fragmentManager, TAG_DEPARTURE);
    }

    public void onArrivalClick(View v) {
        datePickerDialog.show(fragmentManager, TAG_ARRIVAL);
    }

    public void onSearchClick(View v) {
        openSearchActivity();
    }

    private void openSearchActivity() {
        Intent intent = new Intent(ACTION_FLIGHT_SEARCH);
        activity.startActivity(intent);
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);
        if (view.getTag().equals(TAG_DEPARTURE)) {
            departure.set(calendarHelper.formatDate(calendar));
        } else {
            arrival.set(calendarHelper.formatDate(calendar));
        }
    }
}
