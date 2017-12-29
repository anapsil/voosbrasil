package net.anapsil.voosbrasil.remote.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.List;

public class Flight implements Serializable, Parcelable {
    public static final Creator<Flight> CREATOR = new Creator<Flight>() {
        @Override
        public Flight createFromParcel(Parcel source) {
            return new Flight(source);
        }

        @Override
        public Flight[] newArray(int size) {
            return new Flight[size];
        }
    };
    private String origin;
    private String flightcode;
    private String depdate;
    private String deptime;
    private String duration;
    private String destination;
    private String stops;
    private Fare fare;
    private List<Flight> returnfl;
    private List<Flight> onwardflights;
    private String arrdate;
    private String arrtime;
    private String airline;

    public Flight() {
    }

    private Flight(Builder builder) {
        setOrigin(builder.origin);
        setFlightcode(builder.flightcode);
        setDepdate(builder.depdate);
        setDeptime(builder.deptime);
        setDuration(builder.duration);
        setDestination(builder.destination);
        setStops(builder.stops);
        setFare(builder.fare);
        setReturnfl(builder.returnfl);
        setOnwardflights(builder.onwardflights);
        setArrdate(builder.arrdate);
        setArrtime(builder.arrtime);
        setAirline(builder.airline);
    }

    protected Flight(Parcel in) {
        this.origin = in.readString();
        this.flightcode = in.readString();
        this.depdate = in.readString();
        this.deptime = in.readString();
        this.duration = in.readString();
        this.destination = in.readString();
        this.stops = in.readString();
        this.fare = in.readParcelable(Fare.class.getClassLoader());
        this.returnfl = in.createTypedArrayList(Flight.CREATOR);
        this.onwardflights = in.createTypedArrayList(Flight.CREATOR);
        this.arrdate = in.readString();
        this.arrtime = in.readString();
        this.airline = in.readString();
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getFlightcode() {
        return flightcode;
    }

    public void setFlightcode(String flightcode) {
        this.flightcode = flightcode;
    }

    public String getDeptime() {
        return deptime;
    }

    public void setDeptime(String deptime) {
        this.deptime = deptime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public List<Flight> getReturnfl() {
        return returnfl;
    }

    public void setReturnfl(List<Flight> returnfl) {
        this.returnfl = returnfl;
    }

    public List<Flight> getOnwardflights() {
        return onwardflights;
    }

    public void setOnwardflights(List<Flight> onwardflights) {
        this.onwardflights = onwardflights;
    }

    public String getDepdate() {
        return depdate;
    }

    public void setDepdate(String depdate) {
        this.depdate = depdate;
    }

    public String getArrdate() {
        return arrdate;
    }

    public void setArrdate(String arrdate) {
        this.arrdate = arrdate;
    }

    public String getArrtime() {
        return arrtime;
    }

    public void setArrtime(String arrtime) {
        this.arrtime = arrtime;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.origin);
        dest.writeString(this.flightcode);
        dest.writeString(this.depdate);
        dest.writeString(this.deptime);
        dest.writeString(this.duration);
        dest.writeString(this.destination);
        dest.writeString(this.stops);
        dest.writeParcelable(this.fare, flags);
        dest.writeTypedList(this.returnfl);
        dest.writeTypedList(this.onwardflights);
        dest.writeString(this.arrdate);
        dest.writeString(this.arrtime);
        dest.writeString(this.airline);
    }

    public static final class Builder {
        private String origin;
        private String flightcode;
        private String deptime;
        private String duration;
        private String destination;
        private String stops;
        private Fare fare;
        private List<Flight> returnfl;
        private List<Flight> onwardflights;
        private String depdate;
        private String arrdate;
        private String arrtime;
        private String airline;

        public Builder() {
        }

        public Builder origin(String val) {
            origin = val;
            return this;
        }

        public Builder flightcode(String val) {
            flightcode = val;
            return this;
        }

        public Builder deptime(String val) {
            deptime = val;
            return this;
        }

        public Builder duration(String val) {
            duration = val;
            return this;
        }

        public Builder destination(String val) {
            destination = val;
            return this;
        }

        public Builder stops(String val) {
            stops = val;
            return this;
        }

        public Builder fare(Fare val) {
            fare = val;
            return this;
        }

        public Builder returnfl(List<Flight> val) {
            returnfl = val;
            return this;
        }

        public Builder onwardflights(List<Flight> val) {
            onwardflights = val;
            return this;
        }

        public Builder depdate(String val) {
            depdate = val;
            return this;
        }

        public Builder arrdate(String val) {
            arrdate = val;
            return this;
        }

        public Builder arrtime(String val) {
            arrtime = val;
            return this;
        }

        public Builder airline(String val) {
            airline = val;
            return this;
        }

        public Flight build() {
            return new Flight(this);
        }
    }
}
