package net.anapsil.voosbrasil.ui.dialogs;

import android.app.DialogFragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.anapsil.voosbrasil.BR;
import net.anapsil.voosbrasil.R;
import net.anapsil.voosbrasil.databinding.DialogFilterBinding;
import net.anapsil.voosbrasil.ui.viewmodels.FilterDialogViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class FilterDialog extends DialogFragment {
    DialogFilterBinding binding;

    @Inject
    FilterDialogViewModel viewModel;

    private OnFilterListener listener;

    public static FilterDialog newInstance() {
        FilterDialog fragment = new FilterDialog();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidInjection.inject(this);
        setCancelable(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_filter, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setVariable(BR.vm, viewModel);
        binding.executePendingBindings();
        viewModel.onViewCreated();
        viewModel.setFilterDialog(this);
    }

    @Override
    public void onDestroyView() {
        viewModel.onDestroyView();
        super.onDestroyView();
    }

    public FilterDialogViewModel getViewModel() {
        return viewModel;
    }

    public OnFilterListener getListener() {
        return listener;
    }

    public void setListener(OnFilterListener listener) {
        this.listener = listener;
    }

    public interface OnFilterListener {
        void onFilter(String option);

        void onCancel();
    }

}
