package net.anapsil.voosbrasil.remote;

import net.anapsil.voosbrasil.remote.models.FlightsResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlightService {

    @GET("api/search/")
    Observable<FlightsResponse> searchForFlights(@Query("app_id") String appId,
                                                 @Query("app_key") String appKey,
                                                 @Query("source") String source,
                                                 @Query("destination") String destination,
                                                 @Query("dateofdeparture") String dateOfDeparture,
                                                 @Query("dateofarrival") String dateOfArrival,
                                                 @Query("adults") int adults,
                                                 @Query("counter") int counter);
}
