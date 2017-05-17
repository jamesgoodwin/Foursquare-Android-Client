package com.locationsearch;

import android.util.Log;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;

class LocationSearchPresenter {

    private final LocationSearchView view;
    private final LocationSearchService locationSearchService;
    private Scheduler backgroundScheduler;
    private Scheduler viewScheduler;

    LocationSearchPresenter(LocationSearchView view,
                            LocationSearchService locationSearchService,
                            Scheduler backgroundScheduler,
                            Scheduler viewScheduler) {
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
                .subscribe(new Consumer<List<Venue>>() {
                    @Override
                    public void accept(List<Venue> venues) {
                        view.showResults(venues);
                        view.showLoading(false);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.e("Foursquare-Client", "Error retrieving results", throwable);
                    }
                });
    }

}
