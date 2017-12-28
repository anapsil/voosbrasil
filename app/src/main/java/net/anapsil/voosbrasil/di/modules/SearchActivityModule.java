package net.anapsil.voosbrasil.di.modules;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.res.Resources;

import net.anapsil.voosbrasil.di.scopes.PerActivity;
import net.anapsil.voosbrasil.helpers.CalendarHelper;
import net.anapsil.voosbrasil.ui.activities.HomeActivity;
import net.anapsil.voosbrasil.ui.activities.SearchActivity;
import net.anapsil.voosbrasil.ui.viewmodels.HomeViewModel;
import net.anapsil.voosbrasil.ui.viewmodels.SearchViewModel;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class SearchActivityModule {

    @Provides
    @PerActivity
    static SearchViewModel providesSearchViewModel(CalendarHelper calendarHelper) {
        return new SearchViewModel(calendarHelper);
    }

    @Binds
    @Named("search")
    abstract Activity bindActivity(SearchActivity activity);

}
