package net.anapsil.voosbrasil.di.modules;

import net.anapsil.voosbrasil.di.scopes.PerActivity;
import net.anapsil.voosbrasil.ui.activities.HomeActivity;
import net.anapsil.voosbrasil.ui.activities.SearchActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = HomeActivityModule.class)
    abstract HomeActivity homeActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = SearchActivityModule.class)
    abstract SearchActivity searchActivity();
}
