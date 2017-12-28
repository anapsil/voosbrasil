package net.anapsil.voosbrasil.ui.activities;

import net.anapsil.voosbrasil.R;
import net.anapsil.voosbrasil.databinding.ActivityHomeBinding;
import net.anapsil.voosbrasil.ui.viewmodels.HomeViewModel;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> {

    @Inject
    HomeViewModel homeViewModel;

    @Override
    public HomeViewModel getViewModel() {
        return homeViewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }
}
