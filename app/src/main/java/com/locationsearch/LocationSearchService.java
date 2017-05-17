package com.locationsearch;

import java.util.List;

import io.reactivex.Single;

interface LocationSearchService {

    Single<List<Venue>> searchVenues(String query);

}
