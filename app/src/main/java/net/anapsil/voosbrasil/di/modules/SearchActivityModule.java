package net.anapsil.voosbrasil.di.modules;

import android.app.Activity;

import net.anapsil.voosbrasil.ui.activities.SearchActivity;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SearchActivityModule {

    @Binds
    @Named("search")
    abstract Activity bindActivity(SearchActivity activity);
}
