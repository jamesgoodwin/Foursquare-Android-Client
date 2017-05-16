package com.locationsearch;

import io.reactivex.Single;

public interface LocationSearchService {

    Single<VenueSearchResult> searchVenues(String query);

}
