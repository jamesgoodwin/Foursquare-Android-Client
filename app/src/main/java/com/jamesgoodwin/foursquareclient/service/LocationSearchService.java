package com.jamesgoodwin.foursquareclient.service;

import com.jamesgoodwin.foursquareclient.model.Venue;

import java.util.List;

import io.reactivex.Single;

public interface LocationSearchService {

    Single<List<Venue>> searchVenues(String query);

}
