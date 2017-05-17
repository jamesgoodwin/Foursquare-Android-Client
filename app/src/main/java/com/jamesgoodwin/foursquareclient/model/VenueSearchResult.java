package com.jamesgoodwin.foursquareclient.model;

import java.util.ArrayList;
import java.util.List;

public class VenueSearchResult {

    private Response response;

    VenueSearchResult(Response response) {
        this.response = response;
    }

    public List<Venue> getVenues() {
        List<Venue> venues = new ArrayList<>();

        for(VenueGroup venueGroup : response.getVenueGroups()) {
            for(VenueResultItem resultItem : venueGroup.getVenues()) {
                venues.add(resultItem.getVenue());
            }
        }

        return venues;
    }

}
