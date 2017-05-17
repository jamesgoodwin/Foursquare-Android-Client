package com.locationsearch;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface FoursquareRetrofitApiService {

    @GET("/v2/venues/explore")
    Single<VenueSearchResult> searchVenues(@Query("client_id") String clientId,
                                           @Query("client_secret") String clientSecret,
                                           @Query("near") String locationNear,
                                           @Query("v") String version);

}
