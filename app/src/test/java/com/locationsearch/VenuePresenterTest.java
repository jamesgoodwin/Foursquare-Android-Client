package com.locationsearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VenuePresenterTest {

    @Mock
    VenueView venueView;

    @Mock
    Venue venue;

    @Mock
    VenueLocation venueLocation;

    @Test
    public void shouldDisplayRating() {
        VenuePresenter presenter = new VenuePresenter();

        float rating = 5.0f;
        when(venue.getRating()).thenReturn(rating);

        presenter.showVenue(venue, venueView);

        verify(venueView)
                .showRating(eq(rating));
    }

    @Test
    public void shouldDisplayZeroRating() {
        VenuePresenter presenter = new VenuePresenter();

        float rating = 0f;
        when(venue.getRating()).thenReturn(rating);

        presenter.showVenue(venue, venueView);

        verify(venueView)
                .showRating(eq(rating));
    }

    @Test
    public void shouldDisplayVenueName() {
        VenuePresenter presenter = new VenuePresenter();

        String venueName = "Hyde park";
        when(venue.getName()).thenReturn(venueName);

        presenter.showVenue(venue, venueView);

        verify(venueView).showVenueName(eq(venueName));
    }

    @Test
    public void shouldDisplayVenueAddress() {
        VenuePresenter presenter = new VenuePresenter();

        String address = "123 Piccadilly";

        when(venueLocation.getFormattedAddress())
                .thenReturn(address);

        when(venue.getLocation()).thenReturn(venueLocation);

        presenter.showVenue(venue, venueView);

        verify(venueView).showVenueAddress(eq(address));
    }

}