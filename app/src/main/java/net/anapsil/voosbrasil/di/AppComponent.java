package net.anapsil.voosbrasil.di;

import android.app.Application;

import net.anapsil.voosbrasil.VoosBrasilApplication;
import net.anapsil.voosbrasil.di.modules.ActivityBindingModule;
import net.anapsil.voosbrasil.di.modules.AppModule;
import net.anapsil.voosbrasil.di.modules.HomeActivityModule;
import net.anapsil.voosbrasil.di.modules.SearchActivityModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AndroidSupportInjectionModule.class, ActivityBindingModule.class, AppModule.class,
        HomeActivityModule.class, SearchActivityModule.class})
public interface AppComponent extends AndroidInjector<VoosBrasilApplication> {

    @Override
    void inject(VoosBrasilApplication instance);

    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
