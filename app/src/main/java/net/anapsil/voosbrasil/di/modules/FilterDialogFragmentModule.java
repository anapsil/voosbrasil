package net.anapsil.voosbrasil.di.modules;

import android.app.DialogFragment;

import net.anapsil.voosbrasil.ui.dialogs.FilterDialog;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class FilterDialogFragmentModule {

    @Binds
    abstract DialogFragment bindActivity(FilterDialog dialog);
}
