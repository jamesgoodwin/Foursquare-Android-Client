package com.jamesgoodwin;

public class LocationSearchPresenter {

    private final LocationSearchView view;
    private final LocationSearchService locationSearchService;

    public LocationSearchPresenter(LocationSearchView view, LocationSearchService locationSearchService) {
        this.view = view;
        this.locationSearchService = locationSearchService;
    }

    public void searchVenues(String query) {
        locationSearchService.searchVenues(query);
    }

}
