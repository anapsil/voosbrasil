package net.anapsil.voosbrasil.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import net.anapsil.voosbrasil.R;
import net.anapsil.voosbrasil.databinding.ActivitySearchBinding;
import net.anapsil.voosbrasil.ui.model.FlightModel;
import net.anapsil.voosbrasil.ui.viewmodels.SearchViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class SearchActivity extends BaseActivity<ActivitySearchBinding, SearchViewModel> {
    public static final String EXTRA_FLIGHTS = "EXTRA_FLIGHTS";
    @Inject
    SearchViewModel searchViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleIntent();

        setSupportActionBar(getViewDataBinding().toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        getViewDataBinding().flights.setHasFixedSize(true);
        getViewDataBinding().flights.setHasFixedSize(true);
        getViewDataBinding().flights.setAdapter(searchViewModel.getAdapter());
    }

    public void handleIntent() {
        ArrayList<FlightModel> flights = getIntent().getParcelableArrayListExtra(EXTRA_FLIGHTS);
        searchViewModel.updateList(flights);
    }

    @Override
    public SearchViewModel getViewModel() {
        return searchViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }
}
