package net.anapsil.voosbrasil.repository;

import net.anapsil.voosbrasil.remote.FlightService;
import net.anapsil.voosbrasil.remote.models.Flight;

import javax.inject.Inject;

import io.reactivex.Observable;

public class FlightRepository {
    private final String APP_ID = "e3d1e531";
    private final String APP_KEY = "d8ecdae935dddcc12beef799647618ca";
    private final int COUNTER = 100;
    private FlightService service;

    @Inject
    public FlightRepository(FlightService service) {
        this.service = service;
    }

    public Observable<Flight> searchFlights(String source, String destination, String dateOfDeparture, String dateOfArrival, int adults) {
        return service.searchForFlights(APP_ID, APP_KEY, source, destination, dateOfDeparture, dateOfArrival, adults, COUNTER)
                .flatMap(response -> Observable.fromIterable(response.getData().getOnwardflights()));
    }
}
