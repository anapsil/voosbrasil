package net.anapsil.voosbrasil.remote.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable, Parcelable {
    private List<Flight> returnFlights;
    private List<Flight> onwardflights;
    @SerializedName("data_length")
    private int dataLength;

    public List<Flight> getReturnFlights() {
        return returnFlights;
    }

    public void setReturnFlights(List<Flight> returnFlights) {
        this.returnFlights = returnFlights;
    }

    public List<Flight> getOnwardflights() {
        return onwardflights;
    }

    public void setOnwardflights(List<Flight> onwardflights) {
        this.onwardflights = onwardflights;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.returnFlights);
        dest.writeList(this.onwardflights);
        dest.writeInt(this.dataLength);
    }

    public Data() {
    }

    protected Data(Parcel in) {
        this.returnFlights = new ArrayList<Flight>();
        in.readList(this.returnFlights, Flight.class.getClassLoader());
        this.onwardflights = new ArrayList<Flight>();
        in.readList(this.onwardflights, Flight.class.getClassLoader());
        this.dataLength = in.readInt();
    }

    public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
        @Override
        public Data createFromParcel(Parcel source) {
            return new Data(source);
        }

        @Override
        public Data[] newArray(int size) {
            return new Data[size];
        }
    };
}
