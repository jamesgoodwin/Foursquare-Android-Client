package com.locationsearch;

import java.util.List;

class VenueSearchResult {

    private Response response;

    VenueSearchResult(Response response) {
        this.response = response;
    }

    public List<VenueResultItem> getVenues() {
        return response.getVenueGroups().getVenues();
    }

}
