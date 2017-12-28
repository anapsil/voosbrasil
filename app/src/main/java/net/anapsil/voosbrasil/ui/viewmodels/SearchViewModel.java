package net.anapsil.voosbrasil.ui.viewmodels;

import net.anapsil.voosbrasil.helpers.CalendarHelper;
import net.anapsil.voosbrasil.remote.models.Flight;

import java.util.List;

public class SearchViewModel extends BaseViewModel {
    private CalendarHelper calendarHelper;

    public SearchViewModel(CalendarHelper calendarHelper) {
        this.calendarHelper = calendarHelper;
    }

    public void updateList(List<Flight> flights) {

    }
}
