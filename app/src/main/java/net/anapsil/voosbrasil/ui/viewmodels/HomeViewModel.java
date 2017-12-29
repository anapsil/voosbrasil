package net.anapsil.voosbrasil.ui.viewmodels;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ArrayAdapter;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import net.anapsil.voosbrasil.R;
import net.anapsil.voosbrasil.business.SearchFlightsBusiness;
import net.anapsil.voosbrasil.database.AppDatabase;
import net.anapsil.voosbrasil.helpers.CalendarHelper;
import net.anapsil.voosbrasil.ui.databinding.ObservableString;
import net.anapsil.voosbrasil.ui.model.FlightModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static net.anapsil.voosbrasil.helpers.CalendarHelper.DEFAULT_PATTERN_DATE;
import static net.anapsil.voosbrasil.helpers.CalendarHelper.PATTERN_YYYYMMDD;

public class HomeViewModel extends RxBaseViewModel implements DatePickerDialog.OnDateSetListener {
    private final String TAG_DEPARTURE = "departure";
    private final String TAG_ARRIVAL = "arrival";
    private final String ACTION_FLIGHT_SEARCH = "net.anapsil.voosbrasil.FLIGHT_SEARCH";

    public ObservableString source = new ObservableString();
    public ObservableString destination = new ObservableString();
    public ObservableString departure = new ObservableString();
    public ObservableString arrival = new ObservableString();
    public ObservableString adults = new ObservableString();

    private DatePickerDialog datePickerDialog;
    private Activity activity;
    private FragmentManager fragmentManager;
    private Resources resources;
    private CalendarHelper calendarHelper;
    private SearchFlightsBusiness business;
    private ArrayAdapter<String> adapter;

    @Inject
    public HomeViewModel(@Named("home") Activity activity, FragmentManager fragmentManager, Resources resources, CalendarHelper calendarHelper, SearchFlightsBusiness business) {
        this.activity = activity;
        this.fragmentManager = fragmentManager;
        this.resources = resources;
        this.calendarHelper = calendarHelper;
        this.business = business;

        departure.set(resources.getString(R.string.departure_date));
        arrival.set(resources.getString(R.string.arrival_date));

        adapter = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1);

        datePickerDialog = DatePickerDialog.newInstance(this,
                calendarHelper.getToday().get(Calendar.YEAR),
                calendarHelper.getToday().get(Calendar.MONTH),
                calendarHelper.getToday().get(Calendar.DAY_OF_MONTH));

        datePickerDialog.setLocale(calendarHelper.getDefaultLocale());
    }

    public ArrayAdapter<String> getAdapter() {
        return adapter;
    }

    public void loadData() {
        disposable.add(AppDatabase.getAppDatabase(activity).airportDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::updateAdapter));
    }

    private void updateAdapter(List<String> airports) {
        adapter.addAll(airports);
        adapter.notifyDataSetChanged();
    }

    public void onDepartureClick(View v) {
        datePickerDialog.show(fragmentManager, TAG_DEPARTURE);
    }

    public void onArrivalClick(View v) {
        datePickerDialog.show(fragmentManager, TAG_ARRIVAL);
    }

    public void onSearchClick(View v) {
        search();
    }

    private void search() {
        disposable.add(business.searchFlights(source.get(), destination.get(),
                calendarHelper.formatDate(departure.get(), DEFAULT_PATTERN_DATE, PATTERN_YYYYMMDD),
                calendarHelper.formatDate(arrival.get(), DEFAULT_PATTERN_DATE, PATTERN_YYYYMMDD),
                Integer.parseInt(adults.get()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::openSearchActivity));
    }

    private void openSearchActivity(List<FlightModel> flights) {
        Intent intent = new Intent(ACTION_FLIGHT_SEARCH);
        intent.putExtra("EXTRA_FLIGHTS", new ArrayList<>(flights));
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
