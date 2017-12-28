package net.anapsil.voosbrasil.ui.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import net.anapsil.voosbrasil.R;
import net.anapsil.voosbrasil.databinding.ActivitySearchBinding;
import net.anapsil.voosbrasil.ui.viewmodels.SearchViewModel;

import javax.inject.Inject;

public class SearchActivity extends BaseActivity<ActivitySearchBinding, SearchViewModel> {

    @Inject
    SearchViewModel searchViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setSupportActionBar(getViewDataBinding().toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
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
