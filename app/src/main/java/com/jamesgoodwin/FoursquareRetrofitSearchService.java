package com.jamesgoodwin;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoursquareRetrofitSearchService {

    @GET("/venues/explore")
    Single<VenueSearchResult> searchVenues(@Query("oauth_token") String oauthToken, @Query("near") String locationNear, @Query("v") String version);

}
