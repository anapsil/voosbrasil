package net.anapsil.voosbrasil.remote;

import net.anapsil.voosbrasil.remote.models.Data;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlightService {

    @GET("api/search")
    Observable<Data> searchForFlights(@Query("app_id") String appId,
                                      @Query("app_key") String appKey,
                                      @Query("format") String format,
                                      @Query("source") String source,
                                      @Query("destination") String destination,
                                      @Query("dateofdeparture") String dateOfDeparture,
                                      @Query("dateofarrival") String dateOfArrival,
                                      @Query("adults") int adults,
                                      @Query("counter") int counter);
}
