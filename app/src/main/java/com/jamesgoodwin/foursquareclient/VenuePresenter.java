package com.jamesgoodwin.foursquareclient;

import com.jamesgoodwin.foursquareclient.model.Venue;

class VenuePresenter {

    void showVenue(Venue venue, VenueView view) {
        float rating = venue.getRating();
        view.showRating(rating > 0 ? rating / 2f : 0);

        view.showVenueName(venue.getName());
        view.showVenueAddress(venue.getLocation().getFormattedAddress());
    }

}