package net.anapsil.voosbrasil.business;

import net.anapsil.voosbrasil.helpers.CalendarHelper;
import net.anapsil.voosbrasil.remote.models.Flight;
import net.anapsil.voosbrasil.repository.FlightRepository;
import net.anapsil.voosbrasil.ui.model.FlightModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

import static net.anapsil.voosbrasil.helpers.CalendarHelper.PATTERN_YYYY_MM_DD_t_HH_MM;

public class SearchFlightsBusiness {
    private FlightRepository repository;
    private CalendarHelper calendarHelper;

    @Inject
    public SearchFlightsBusiness(FlightRepository repository, CalendarHelper calendarHelper) {
        this.repository = repository;
        this.calendarHelper = calendarHelper;
    }

    public Single<List<FlightModel>> searchFlights(String source, String destination, String dateOfDeparture, String dateOfArrival, int adults) {
        return repository.searchFlights(source, destination, dateOfDeparture, dateOfArrival, adults)
                .flatMap(this::parseFlight)
                .toList();
    }

    private Observable<FlightModel> parseFlight(Flight flight) {
        FlightModel model = new FlightModel.Builder()
                .onwardDate(calendarHelper.formatFullDate(flight.getDepdate(), PATTERN_YYYY_MM_DD_t_HH_MM))
                .onwardAirline(flight.getAirline().split(" ")[0])
                .onwardDepartureTime(flight.getDeptime())
                .onwardDuration(flight.getDuration().replace(" ", "").replace("m", "").toUpperCase())
                .onwardArrivalTime(getArrivalTime(flight))
                .onwardFlightNumber(flight.getFlightcode().toUpperCase())
                .onwardSource(flight.getOrigin())
                .onwardStops(Integer.parseInt(flight.getStops()))
                .onwardDestination(getDestination(flight))
                .returnDate(calendarHelper.formatFullDate(flight.getReturnfl().get(0).getDepdate(), PATTERN_YYYY_MM_DD_t_HH_MM))
                .returnAirline(flight.getReturnfl().get(0).getAirline().split(" ")[0])
                .returnDepartureTime(flight.getReturnfl().get(0).getDeptime())
                .fare(flight.getFare().getTotalfare() / 100)
                .build();

        return Observable.just(model);
    }

    private String getArrivalTime(Flight flight) {
        return Integer.parseInt(flight.getStops()) > 0 ?
                flight.getOnwardflights().get(flight.getOnwardflights().size() - 1).getArrtime() :
                flight.getArrtime();
    }

    private String getDestination(Flight flight) {
        return Integer.parseInt(flight.getStops()) > 0 ?
                flight.getOnwardflights().get(flight.getOnwardflights().size() - 1).getDestination() :
                flight.getDestination();
    }
}
