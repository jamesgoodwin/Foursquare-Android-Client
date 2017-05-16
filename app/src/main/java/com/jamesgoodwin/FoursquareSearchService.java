package com.jamesgoodwin;

import io.reactivex.Single;

public class FoursquareSearchService implements LocationSearchService {

    private static final String OAUTH_TOKEN = "XPHDQHEKKFKO3GLKUBFXAWW3LHKH32RCLR2ZNNEXPCA2TWG0";
    private static final String API_VERSION = "20170515";

    private FoursquareRetrofitSearchService apiService;

    public FoursquareSearchService(FoursquareRetrofitSearchService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<VenueSearchResult> searchVenues(String location) {
        return apiService.searchVenues(OAUTH_TOKEN, location, API_VERSION);
    }

}