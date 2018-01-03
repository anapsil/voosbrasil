package net.anapsil.voosbrasil.ui.adapters;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import net.anapsil.voosbrasil.R;
import net.anapsil.voosbrasil.ui.model.FlightModel;
import net.anapsil.voosbrasil.ui.viewmodels.FlightItemViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class FlightsAdapter extends RecyclerView.Adapter<FlightViewHolder> implements Filterable {
    private List<FlightModel> flights = Collections.emptyList();
    private List<FlightModel> filteredFlights = Collections.emptyList();
    private Resources resources;

    @Inject
    public FlightsAdapter(Resources resources) {
        this.resources = resources;
    }

    public void setFlights(List<FlightModel> flights) {
        this.flights = flights;
        this.filteredFlights = flights;
        notifyDataSetChanged();
    }

    @Override
    public FlightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flight, parent, false);
        return new FlightViewHolder(itemView, new FlightItemViewModel(resources));
    }

    @Override
    public void onBindViewHolder(FlightViewHolder holder, int position) {
        holder.getViewModel().update(filteredFlights.get(position));
        holder.executePendingBindings();
    }

    public void sort() {
        Collections.sort(filteredFlights);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return filteredFlights.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString();

                if (query.isEmpty()) {
                    filteredFlights = flights;
                } else {
                    List<FlightModel> filteredList = new ArrayList<>();
                    for (FlightModel f : flights) {
                        if (f.getOnwardAirline().equals(query)) {
                            filteredList.add(f);
                        }
                    }

                    filteredFlights = filteredList;
                }

                FilterResults filterResults = new FilterResults();

                filterResults.values = filteredFlights;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredFlights = (ArrayList<FlightModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
