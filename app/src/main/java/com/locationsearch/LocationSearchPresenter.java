package com.locationsearch;

import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

class LocationSearchPresenter {

    private final LocationSearchView view;
    private final LocationSearchService locationSearchService;
    private Scheduler backgroundScheduler;
    private Scheduler viewScheduler;

    LocationSearchPresenter(LocationSearchView view, LocationSearchService locationSearchService, Scheduler backgroundScheduler, Scheduler viewScheduler) {
        this.view = view;
        this.locationSearchService = locationSearchService;
        this.backgroundScheduler = backgroundScheduler;
        this.viewScheduler = viewScheduler;
    }

    void searchVenues(String query) {
        view.showLoading(true);

        locationSearchService.searchVenues(query)
                .subscribeOn(backgroundScheduler)
                .observeOn(viewScheduler)
                .doAfterTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        view.showLoading(false);
                    }
                })
                .subscribe(new Consumer<VenueSearchResult>() {
                    @Override
                    public void accept(VenueSearchResult venueSearchResult) {
                        view.showResults(venueSearchResult.getVenues());
                    }
                });
    }

}
