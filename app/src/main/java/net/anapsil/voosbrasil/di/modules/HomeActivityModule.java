package net.anapsil.voosbrasil.di.modules;

import android.app.Activity;
import android.app.FragmentManager;

import net.anapsil.voosbrasil.di.scopes.PerActivity;
import net.anapsil.voosbrasil.ui.activities.HomeActivity;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class HomeActivityModule {

//    @Provides
//    @PerActivity
//    static HomeViewModel providesHomeViewModel(@Named("home") Activity activity, FragmentManager fragmentManager, Resources resources, CalendarHelper calendarHelper) {
//        return new HomeViewModel(activity, fragmentManager, resources, calendarHelper);
//    }

    @Provides
    @PerActivity
    static FragmentManager providesFragmentManager(HomeActivity activity) {
        return activity.getFragmentManager();
    }

    @Binds
    @Named("home")
    abstract Activity bindActivity(HomeActivity activity);
}
