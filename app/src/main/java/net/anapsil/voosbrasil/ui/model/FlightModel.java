package net.anapsil.voosbrasil.ui.model;

import android.os.Parcel;
import android.os.Parcelable;

public class FlightModel implements Parcelable {

    public static final Creator<FlightModel> CREATOR = new Creator<FlightModel>() {
        @Override
        public FlightModel createFromParcel(Parcel source) {
            return new FlightModel(source);
        }

        @Override
        public FlightModel[] newArray(int size) {
            return new FlightModel[size];
        }
    };
    private String onwardDate;
    private String onwardAirline;
    private String onwardDepartureTime;
    private String onwardDuration;
    private String onwardArrivalTime;
    private String onwardFlightNumber;
    private String onwardSource;
    private int onwardStops;
    private String onwardDestination;
    private String returnDate;
    private String returnAirline;
    private String returnDepartureTime;
    private String returnDuration;
    private String returnArrivalTime;
    private String returnFlightNumber;
    private String returnSource;
    private int returnStops;
    private String returnDestination;
    private double fare;

    private FlightModel(Builder builder) {
        onwardDate = builder.onwardDate;
        onwardAirline = builder.onwardAirline;
        onwardDepartureTime = builder.onwardDepartureTime;
        onwardDuration = builder.onwardDuration;
        onwardArrivalTime = builder.onwardArrivalTime;
        onwardFlightNumber = builder.onwardFlightNumber;
        onwardSource = builder.onwardSource;
        onwardStops = builder.onwardStops;
        onwardDestination = builder.onwardDestination;
        returnDate = builder.returnDate;
        returnAirline = builder.returnAirline;
        returnDepartureTime = builder.returnDepartureTime;
        returnDuration = builder.returnDuration;
        returnArrivalTime = builder.returnArrivalTime;
        returnFlightNumber = builder.returnFlightNumber;
        returnSource = builder.returnSource;
        returnStops = builder.returnStops;
        returnDestination = builder.returnDestination;
        fare = builder.fare;
    }

    public FlightModel() {
    }

    protected FlightModel(Parcel in) {
        this.onwardDate = in.readString();
        this.onwardAirline = in.readString();
        this.onwardDepartureTime = in.readString();
        this.onwardDuration = in.readString();
        this.onwardArrivalTime = in.readString();
        this.onwardFlightNumber = in.readString();
        this.onwardSource = in.readString();
        this.onwardStops = in.readInt();
        this.onwardDestination = in.readString();
        this.returnDate = in.readString();
        this.returnAirline = in.readString();
        this.returnDepartureTime = in.readString();
        this.returnDuration = in.readString();
        this.returnArrivalTime = in.readString();
        this.returnFlightNumber = in.readString();
        this.returnSource = in.readString();
        this.returnStops = in.readInt();
        this.returnDestination = in.readString();
        this.fare = in.readDouble();
    }

    public String getOnwardDate() {
        return onwardDate;
    }

    public String getOnwardAirline() {
        return onwardAirline;
    }

    public String getOnwardDepartureTime() {
        return onwardDepartureTime;
    }

    public String getOnwardDuration() {
        return onwardDuration;
    }

    public String getOnwardArrivalTime() {
        return onwardArrivalTime;
    }

    public String getOnwardFlightNumber() {
        return onwardFlightNumber;
    }

    public String getOnwardSource() {
        return onwardSource;
    }

    public int getOnwardStops() {
        return onwardStops;
    }

    public String getOnwardDestination() {
        return onwardDestination;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public String getReturnAirline() {
        return returnAirline;
    }

    public String getReturnDepartureTime() {
        return returnDepartureTime;
    }

    public String getReturnDuration() {
        return returnDuration;
    }

    public String getReturnArrivalTime() {
        return returnArrivalTime;
    }

    public String getReturnFlightNumber() {
        return returnFlightNumber;
    }

    public String getReturnSource() {
        return returnSource;
    }

    public int getReturnStops() {
        return returnStops;
    }

    public String getReturnDestination() {
        return returnDestination;
    }

    public double getFare() {
        return fare;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.onwardDate);
        dest.writeString(this.onwardAirline);
        dest.writeString(this.onwardDepartureTime);
        dest.writeString(this.onwardDuration);
        dest.writeString(this.onwardArrivalTime);
        dest.writeString(this.onwardFlightNumber);
        dest.writeString(this.onwardSource);
        dest.writeInt(this.onwardStops);
        dest.writeString(this.onwardDestination);
        dest.writeString(this.returnDate);
        dest.writeString(this.returnAirline);
        dest.writeString(this.returnDepartureTime);
        dest.writeString(this.returnDuration);
        dest.writeString(this.returnArrivalTime);
        dest.writeString(this.returnFlightNumber);
        dest.writeString(this.returnSource);
        dest.writeInt(this.returnStops);
        dest.writeString(this.returnDestination);
        dest.writeDouble(this.fare);
    }

    public static final class Builder {
        private String onwardDate;
        private String onwardAirline;
        private String onwardDepartureTime;
        private String onwardDuration;
        private String onwardArrivalTime;
        private String onwardFlightNumber;
        private String onwardSource;
        private int onwardStops;
        private String onwardDestination;
        private String returnDate;
        private String returnAirline;
        private String returnDepartureTime;
        private String returnDuration;
        private String returnArrivalTime;
        private String returnFlightNumber;
        private String returnSource;
        private int returnStops;
        private String returnDestination;
        private double fare;

        public Builder() {
        }

        public Builder onwardDate(String val) {
            onwardDate = val;
            return this;
        }

        public Builder onwardAirline(String val) {
            onwardAirline = val;
            return this;
        }

        public Builder onwardDepartureTime(String val) {
            onwardDepartureTime = val;
            return this;
        }

        public Builder onwardDuration(String val) {
            onwardDuration = val;
            return this;
        }

        public Builder onwardArrivalTime(String val) {
            onwardArrivalTime = val;
            return this;
        }

        public Builder onwardFlightNumber(String val) {
            onwardFlightNumber = val;
            return this;
        }

        public Builder onwardSource(String val) {
            onwardSource = val;
            return this;
        }

        public Builder onwardStops(int val) {
            onwardStops = val;
            return this;
        }

        public Builder onwardDestination(String val) {
            onwardDestination = val;
            return this;
        }

        public Builder returnDate(String val) {
            returnDate = val;
            return this;
        }

        public Builder returnAirline(String val) {
            returnAirline = val;
            return this;
        }

        public Builder returnDepartureTime(String val) {
            returnDepartureTime = val;
            return this;
        }

        public Builder returnDuration(String val) {
            returnDuration = val;
            return this;
        }

        public Builder returnArrivalTime(String val) {
            returnArrivalTime = val;
            return this;
        }

        public Builder returnFlightNumber(String val) {
            returnFlightNumber = val;
            return this;
        }

        public Builder returnSource(String val) {
            returnSource = val;
            return this;
        }

        public Builder returnStops(int val) {
            returnStops = val;
            return this;
        }

        public Builder returnDestination(String val) {
            returnDestination = val;
            return this;
        }

        public Builder fare(double val) {
            fare = val;
            return this;
        }

        public FlightModel build() {
            return new FlightModel(this);
        }
    }
}
