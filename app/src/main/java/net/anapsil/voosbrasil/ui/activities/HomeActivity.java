package net.anapsil.voosbrasil.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import net.anapsil.voosbrasil.R;
import net.anapsil.voosbrasil.databinding.ActivityHomeBinding;
import net.anapsil.voosbrasil.ui.viewmodels.HomeViewModel;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> {

    @Inject
    HomeViewModel homeViewModel;

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getViewDataBinding().source.setAdapter(homeViewModel.getAdapter());
        getViewDataBinding().destination.setAdapter(homeViewModel.getAdapter());

        getViewDataBinding().source.setThreshold(1);
        getViewDataBinding().destination.setThreshold(1);

        homeViewModel.loadData();
    }

    @Override
    public HomeViewModel getViewModel() {
        return homeViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }
}
