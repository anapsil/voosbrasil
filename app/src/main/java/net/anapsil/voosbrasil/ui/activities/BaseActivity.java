package net.anapsil.voosbrasil.ui.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import net.anapsil.voosbrasil.BR;
import net.anapsil.voosbrasil.ui.viewmodels.BaseViewModel;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity<B extends ViewDataBinding, VM extends BaseViewModel> extends DaggerAppCompatActivity {
    private B viewDataBinding;
    private VM viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();
        viewModel.onViewCreated();
    }

    @Override
    protected void onDestroy() {
        viewModel.onDestroyView();
        super.onDestroy();
    }

    private void performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        viewModel = getViewModel();
        viewDataBinding.setVariable(BR.vm, viewModel);
        viewDataBinding.executePendingBindings();
    }

    public void showCriticalMessage(int titleId, int messageId) {
        showCriticalMessage(getString(titleId), getString(messageId));
    }

    public void showCriticalMessage(String title, String message) {
        new AlertDialog.Builder(this, android.support.v7.appcompat.R.style.Theme_AppCompat_Light_Dialog_Alert)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    public void showMessage(String message) {
        Snackbar.make(viewDataBinding.getRoot(), message, Snackbar.LENGTH_LONG).show();
    }

    public void showMessageWithAction(int messageId, int actionLabelId, View.OnClickListener listener) {
        Snackbar.make(viewDataBinding.getRoot(), messageId, Snackbar.LENGTH_INDEFINITE)
                .setAction(actionLabelId, listener)
                .show();
    }

    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public B getViewDataBinding() {
        return viewDataBinding;
    }

    public abstract VM getViewModel();

    public abstract int getLayoutId();
}
