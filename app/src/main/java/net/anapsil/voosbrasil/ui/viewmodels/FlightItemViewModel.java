package net.anapsil.voosbrasil.ui.viewmodels;

import android.content.res.Resources;
import android.view.View;

import net.anapsil.voosbrasil.R;
import net.anapsil.voosbrasil.ui.databinding.ObservableString;
import net.anapsil.voosbrasil.ui.model.FlightModel;

public class FlightItemViewModel extends BaseViewModel implements BaseItemViewModel<FlightModel> {
    public ObservableString onwardDate = new ObservableString();
    public ObservableString onwardAirline = new ObservableString();
    public ObservableString onwardDepartureTime = new ObservableString();
    public ObservableString onwardDuration = new ObservableString();
    public ObservableString onwardArrival = new ObservableString();
    public ObservableString onwardFlightNumber = new ObservableString();
    public ObservableString onwardOrigin = new ObservableString();
    public ObservableString onwardDestination = new ObservableString();
    public ObservableString onwardStops = new ObservableString();

    public ObservableString returnDate = new ObservableString();
    public ObservableString returnAirline = new ObservableString();
    public ObservableString returnDepartureTime = new ObservableString();
    public ObservableString returnDuration = new ObservableString();
    public ObservableString returnArrival = new ObservableString();
    public ObservableString returnFlightNumber = new ObservableString();
    public ObservableString returnOrigin = new ObservableString();
    public ObservableString returnDestination = new ObservableString();
    public ObservableString returnStops = new ObservableString();
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
        //No usecase for this method
    }

    @Override
    public void update(FlightModel item) {
        this.model = item;
        setProperties();
        notifyChange();
    }

    private void setProperties() {
        setOnwardProperties();
        setReturnProperties();
        fare.set(String.format(resources.getString(R.string.buy), model.getFare()));
    }

    private void setOnwardProperties() {
        onwardDate.set(model.getOnwardDate());
        onwardAirline.set(model.getOnwardAirline());
        onwardDepartureTime.set(model.getOnwardDepartureTime());
        onwardDuration.set(model.getOnwardDuration());
        onwardArrival.set(model.getOnwardArrivalTime());
        onwardFlightNumber.set(model.getOnwardFlightNumber());
        onwardOrigin.set(model.getOnwardSource());

        if (model.getOnwardStops() == 0) {
            onwardStops.set(resources.getString(R.string.no_stops));
        } else {
            onwardStops.set(resources.getQuantityString(R.plurals.stops, model.getOnwardStops(), model.getOnwardStops()));
        }

        onwardDestination.set(model.getOnwardDestination());
    }

    private void setReturnProperties() {
        returnDate.set(model.getReturnDate());
        returnAirline.set(model.getReturnAirline());
        returnDepartureTime.set(model.getReturnDepartureTime());
        returnDuration.set(model.getReturnDuration());
        returnArrival.set(model.getReturnArrivalTime());
        returnFlightNumber.set(model.getReturnFlightNumber());
        returnOrigin.set(model.getReturnSource());

        if (model.getReturnStops() == 0) {
            returnStops.set(resources.getString(R.string.no_stops));
        } else {
            returnStops.set(resources.getQuantityString(R.plurals.stops, model.getReturnStops(), model.getReturnStops()));
        }

        returnDestination.set(model.getReturnDestination());
    }
}
