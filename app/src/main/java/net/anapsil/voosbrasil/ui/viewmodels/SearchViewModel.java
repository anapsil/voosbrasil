package net.anapsil.voosbrasil.ui.viewmodels;

import android.view.View;

import net.anapsil.voosbrasil.ui.adapters.FlightsAdapter;
import net.anapsil.voosbrasil.ui.model.FlightModel;

import java.util.List;

import javax.inject.Inject;

public class SearchViewModel extends BaseViewModel {
    private FlightsAdapter adapter;

    @Inject
    public SearchViewModel(FlightsAdapter adapter) {
        this.adapter = adapter;
    }

    public FlightsAdapter getAdapter() {
        return adapter;
    }

    public void updateList(List<FlightModel> flights) {
        adapter.setFlights(flights);
    }

    public void onSortClick(View v) {

    }

    public void onFilterClick(View v) {

    }
}
