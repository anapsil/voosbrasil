package net.anapsil.voosbrasil.ui.viewmodels;

import android.content.res.Resources;
import android.view.View;

import net.anapsil.voosbrasil.R;
import net.anapsil.voosbrasil.ui.databinding.ObservableString;
import net.anapsil.voosbrasil.ui.model.FlightModel;

public class FlightItemViewModel extends BaseViewModel implements BaseItemViewModel<FlightModel> {
    public ObservableString onwardTripDate = new ObservableString();
    public ObservableString onwardAirline = new ObservableString();
    public ObservableString onwardDepartureTime = new ObservableString();
    public ObservableString onwardStops = new ObservableString();
    public ObservableString fare = new ObservableString();
    private FlightModel model;
    private Resources resources;

    public FlightItemViewModel(Resources resources) {
        this.resources = resources;
    }

    public void setModel(FlightModel model) {
        this.model = model;
    }

    @Override
    public void onItemClick(View v) {

    }

    @Override
    public void update(FlightModel item) {
        this.model = item;
        setProperties();
        notifyChange();
    }

    private void setProperties() {
        onwardTripDate.set(model.getOnwardDate());
        onwardAirline.set(model.getOnwardAirline());
        onwardDepartureTime.set(model.getOnwardDepartureTime());
        if (model.getOnwardStops() == 0) {
            onwardStops.set(resources.getString(R.string.no_stops));
        } else {
            onwardStops.set(resources.getQuantityString(R.plurals.stops, model.getOnwardStops(), model.getOnwardStops()));
        }
        fare.set(String.format(resources.getString(R.string.buy), model.getFare()));
    }
}
