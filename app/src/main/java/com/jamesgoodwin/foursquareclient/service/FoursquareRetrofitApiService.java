package com.jamesgoodwin.foursquareclient.service;

import com.jamesgoodwin.foursquareclient.model.VenueSearchResult;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoursquareRetrofitApiService {

    @GET("/v2/venues/explore")
    Single<VenueSearchResult> searchVenues(@Query("client_id") String clientId,
                                           @Query("client_secret") String clientSecret,
                                           @Query("near") String locationNear,
                                           @Query("v") String version);

}
