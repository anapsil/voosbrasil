package net.anapsil.voosbrasil.ui.adapters;

import android.view.View;

import net.anapsil.voosbrasil.databinding.ItemFlightBinding;
import net.anapsil.voosbrasil.ui.viewmodels.FlightItemViewModel;

public class FlightViewHolder extends BaseViewHolder<ItemFlightBinding, FlightItemViewModel> {

    FlightItemViewModel flightItemViewModel;

    public FlightViewHolder(View itemView, FlightItemViewModel flightItemViewModel) {
        super(itemView);
        this.flightItemViewModel = flightItemViewModel;
        bindContent(itemView);
        binding.line1.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        binding.line2.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    public FlightItemViewModel getViewModel() {
        return flightItemViewModel;
    }
}
