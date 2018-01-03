package net.anapsil.voosbrasil.ui.viewmodels;

import android.app.Activity;
import android.view.View;

import net.anapsil.voosbrasil.ui.adapters.FlightsAdapter;
import net.anapsil.voosbrasil.ui.dialogs.FilterDialog;
import net.anapsil.voosbrasil.ui.model.FlightModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

public class SearchViewModel extends BaseViewModel implements FilterDialog.OnFilterListener {
    private FlightsAdapter adapter;
    private Activity activity;
    private FilterDialog dialog;

    @Inject
    public SearchViewModel(FlightsAdapter adapter, @Named("search") Activity activity) {
        this.adapter = adapter;
        this.activity = activity;
        dialog = FilterDialog.newInstance();
        dialog.setListener(this);
    }

    @Override
    public void onViewCreated() {
        super.onViewCreated();
    }

    public FlightsAdapter getAdapter() {
        return adapter;
    }

    public void updateList(List<FlightModel> flights) {
        adapter.setFlights(flights);
    }

    public void onSortClick(View v) {
        adapter.sort();
    }

    public void onFilterClick(View v) {
        dialog.show(activity.getFragmentManager(), "filter");
    }

    @Override
    public void onFilter(String option) {
        adapter.getFilter().filter(option);
        dialog.dismiss();
    }

    @Override
    public void onCancel() {
        dialog.dismiss();
    }
}
