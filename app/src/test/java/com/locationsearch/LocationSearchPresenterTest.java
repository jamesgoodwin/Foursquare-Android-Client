package com.locationsearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import io.reactivex.schedulers.TestScheduler;

import static io.reactivex.Single.just;
import static org.mockito.Matchers.anyListOf;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LocationSearchPresenterTest {

    @Mock
    LocationSearchView locationSearchView;

    @Mock
    LocationSearchService locationSearchService;

    @Mock
    List<Venue> venues;

    @Test
    public void shouldDisplayLoadingViewWhenSearching() {
        TestScheduler scheduler = new TestScheduler();
        LocationSearchPresenter presenter = new LocationSearchPresenter(locationSearchView, locationSearchService, scheduler, scheduler);

        String searchTerm = "London";

        when(locationSearchService.searchVenues(eq(searchTerm)))
                .thenReturn(just(venues));

        presenter.searchVenues(searchTerm);

        scheduler.triggerActions();

        verify(locationSearchView).showLoading(eq(true));
    }

    @Test
    public void shouldDisplaySearchResultsInView() {
        TestScheduler scheduler = new TestScheduler();
        LocationSearchPresenter presenter = new LocationSearchPresenter(locationSearchView, locationSearchService, scheduler, scheduler);

        String searchTerm = "London";

        when(locationSearchService.searchVenues(eq(searchTerm)))
                .thenReturn(just(venues));

        presenter.searchVenues(searchTerm);

        scheduler.triggerActions();

        verify(locationSearchView)
                .showResults(anyListOf(Venue.class));
    }

}