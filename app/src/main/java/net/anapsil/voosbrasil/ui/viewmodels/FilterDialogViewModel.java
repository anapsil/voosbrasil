package net.anapsil.voosbrasil.ui.viewmodels;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;

import net.anapsil.voosbrasil.R;
import net.anapsil.voosbrasil.ui.dialogs.FilterDialog;

import javax.inject.Inject;

public class FilterDialogViewModel extends BaseViewModel {
    private String option = "";

    private FilterDialog filterDialog;
    private Resources resources;

    @Inject
    public FilterDialogViewModel(Resources resources) {
        this.resources = resources;
    }

    public void setFilterDialog(FilterDialog filterDialog) {
        this.filterDialog = filterDialog;
    }

    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.option_azul:
                option = resources.getString(R.string.azul);
                break;
            case R.id.option_gol:
                option = resources.getString(R.string.gol);
                break;
            case R.id.option_latam:
                option = resources.getString(R.string.latam);
                break;
            default:
                option = "";
        }
        Log.d("Checked changed", option);
    }

    public void onCancelClick(View v) {
        filterDialog.getListener().onCancel();
    }

    public void onOkClick(View v) {
        filterDialog.getListener().onFilter(option.toUpperCase());
    }
}
