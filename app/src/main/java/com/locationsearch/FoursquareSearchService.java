package com.locationsearch;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

import static java.util.Collections.unmodifiableList;

class FoursquareSearchService implements LocationSearchService {

    private static final String CLIENT_ID = "CKKTF5K1MIYOAQ31QCFM1MP4PADWMRE31DFZAJ0N2NLWYKGY";
    private static final String CLIENT_SECRET = "QALYG22JISYEFQV2MBP1TEEUQF0PJRPLBZEDE1NKDHNIUOZJ";
    private static final String API_VERSION = "20161016";

    private FoursquareRetrofitApiService apiService;

    FoursquareSearchService(FoursquareRetrofitApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public Single<List<Venue>> searchVenues(String location) {
        return apiService.searchVenues(CLIENT_ID, CLIENT_SECRET, location, API_VERSION)
                .flatMap(new Function<VenueSearchResult, SingleSource<List<Venue>>>() {
                    @Override
                    public SingleSource<List<Venue>> apply(VenueSearchResult venueSearchResult) throws Exception {
                        return Single.just(unmodifiableList(venueSearchResult.getVenues()));
                    }
                });
    }

}