package net.anapsil.voosbrasil.di.modules;

import android.app.Application;
import android.content.res.Resources;

import net.anapsil.voosbrasil.helpers.CalendarHelper;

import java.util.Locale;

import dagger.Module;
import dagger.Provides;

@Module(includes = DataserviceModule.class)
public abstract class AppModule {

    @Provides
    static Resources provideResources(Application application) {
        return application.getResources();
    }

    @Provides
    static Locale provideLocale() {
        return new Locale("pt", "BR");
    }

    @Provides
    static CalendarHelper provideCalendarHelper(Locale locale) {
        return new CalendarHelper(locale);
    }
}
