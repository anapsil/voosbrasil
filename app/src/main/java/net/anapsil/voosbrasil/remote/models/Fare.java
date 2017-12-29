package net.anapsil.voosbrasil.remote.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Fare implements Serializable, Parcelable {
    public static final Parcelable.Creator<Fare> CREATOR = new Parcelable.Creator<Fare>() {
        @Override
        public Fare createFromParcel(Parcel source) {
            return new Fare(source);
        }

        @Override
        public Fare[] newArray(int size) {
            return new Fare[size];
        }
    };
    private long totalfare;

    public Fare() {
    }

    protected Fare(Parcel in) {
        this.totalfare = in.readLong();
    }

    public long getTotalfare() {
        return totalfare;
    }

    public void setTotalfare(long totalfare) {
        this.totalfare = totalfare;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.totalfare);
    }
}
