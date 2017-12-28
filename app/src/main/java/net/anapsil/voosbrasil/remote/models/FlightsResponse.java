package net.anapsil.voosbrasil.remote.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class FlightsResponse implements Serializable, Parcelable {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.data);
    }

    public FlightsResponse() {
    }

    protected FlightsResponse(Parcel in) {
        this.data = (Data) in.readSerializable();
    }

    public static final Parcelable.Creator<FlightsResponse> CREATOR = new Parcelable.Creator<FlightsResponse>() {
        @Override
        public FlightsResponse createFromParcel(Parcel source) {
            return new FlightsResponse(source);
        }

        @Override
        public FlightsResponse[] newArray(int size) {
            return new FlightsResponse[size];
        }
    };
}
