package net.anapsil.voosbrasil.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface AirportDao {

    @Query("SELECT iata FROM airports")
    Maybe<List<String>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Airport airport);
}
