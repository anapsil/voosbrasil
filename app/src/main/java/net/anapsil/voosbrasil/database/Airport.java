package net.anapsil.voosbrasil.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "airports")
public class Airport {

    @PrimaryKey
    @NonNull
    private String iata;
    private String name;

    public Airport(@NonNull String iata, String name) {
        this.iata = iata;
        this.name = name;
    }

    @Ignore
    private Airport(Builder builder) {
        setIata(builder.iata);
        setName(builder.name);
    }


    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class Builder {
        private String iata;
        private String name;

        public Builder() {
        }

        public Builder iata(String val) {
            iata = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Airport build() {
            return new Airport(this);
        }
    }
}
