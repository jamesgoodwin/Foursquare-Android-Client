package com.locationsearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
    VenueSearchResult venueSearchResult;

    @Test
    public void shouldDisplayLoadingViewWhenSearching() {
        TestScheduler testScheduler = new TestScheduler();
        LocationSearchPresenter presenter = new LocationSearchPresenter(locationSearchView, locationSearchService, testScheduler, testScheduler);

        String searchTerm = "London";

        when(locationSearchService.searchVenues(eq(searchTerm)))
                .thenReturn(just(venueSearchResult));

        presenter.searchVenues(searchTerm);

        testScheduler.triggerActions();

        verify(locationSearchView).showLoading(eq(true));
    }

    @Test
    public void shouldDisplaySearchResultsInView() {
        TestScheduler testScheduler = new TestScheduler();
        LocationSearchPresenter presenter = new LocationSearchPresenter(locationSearchView, locationSearchService, testScheduler, testScheduler);

        String searchTerm = "London";

        when(locationSearchService.searchVenues(eq(searchTerm)))
                .thenReturn(just(venueSearchResult));

        presenter.searchVenues(searchTerm);

        testScheduler.triggerActions();

        verify(locationSearchView).showResults(anyListOf(VenueResultItem.class));
    }

}