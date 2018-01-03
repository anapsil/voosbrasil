package net.anapsil.voosbrasil.di.modules;

import net.anapsil.voosbrasil.ui.dialogs.FilterDialog;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBindingModule {

    @ContributesAndroidInjector(modules = FilterDialogFragmentModule.class)
    abstract FilterDialog filterDialog();
}
