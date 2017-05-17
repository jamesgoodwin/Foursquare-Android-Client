package com.locationsearch;

import java.util.List;

public class VenueResultItem {

    private Venue venue;
    private List<VenueCategory> categories;

    public VenueResultItem(Venue venue, List<VenueCategory> categories) {
        this.venue = venue;
        this.categories = categories;
    }

    public Venue getVenue() {
        return venue;
    }

    public List<VenueCategory> getCategories() {
        return categories;
    }
}
