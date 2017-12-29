package net.anapsil.voosbrasil.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.anapsil.voosbrasil.helpers.IOHelper;

import java.lang.reflect.Type;
import java.util.List;

@Database(entities = {Airport.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,
                    "airports_db")
                    .addCallback(getCallback(context))
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback getCallback(Context context) {
        return new RoomDatabase.Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
                super.onCreate(db);
                Type type = new TypeToken<List<Airport>>() {
                }.getType();
                List<Airport> airports = new Gson().fromJson(IOHelper.loadJSONFromAsset(context, "airports.json"), type);
                ContentValues contentValues = new ContentValues();

                for (Airport a : airports) {
                    contentValues.put("iata", a.getIata());
                    contentValues.put("name", a.getName());
                    db.insert("airports", OnConflictStrategy.IGNORE, contentValues);
                }


                Log.d("db create", "table created when db created first time in  onCreate");
            }
        };
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract AirportDao airportDao();
}
