package net.anapsil.voosbrasil.ui.adapters;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.anapsil.voosbrasil.R;
import net.anapsil.voosbrasil.ui.model.FlightModel;
import net.anapsil.voosbrasil.ui.viewmodels.FlightItemViewModel;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class FlightsAdapter extends RecyclerView.Adapter<FlightViewHolder> {
    private List<FlightModel> flights = Collections.emptyList();
    private List<FlightModel> filteredFlights = Collections.emptyList();
    private boolean isFiltering;
    private Resources resources;

    @Inject
    public FlightsAdapter(Resources resources) {
        this.resources = resources;
    }

    public void setFlights(List<FlightModel> flights) {
        this.flights = flights;
        notifyDataSetChanged();
    }

    @Override
    public FlightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flight, parent, false);
        return new FlightViewHolder(itemView, new FlightItemViewModel(resources));
    }

    @Override
    public void onBindViewHolder(FlightViewHolder holder, int position) {
        holder.getViewModel().update(flights.get(position));
        holder.executePendingBindings();
    }

    public void filter() {
        notifyDataSetChanged();
    }

    public void sort() {
        Collections.sort(flights);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return isFiltering ? filteredFlights.size() : flights.size();
    }
}
