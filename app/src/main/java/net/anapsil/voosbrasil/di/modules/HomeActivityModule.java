package net.anapsil.voosbrasil.di.modules;

import android.app.Activity;

import net.anapsil.voosbrasil.ui.activities.HomeActivity;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class HomeActivityModule {

    @Binds
    @Named("home")
    abstract Activity bindActivity(HomeActivity activity);
}
