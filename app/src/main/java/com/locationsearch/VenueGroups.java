package com.locationsearch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VenueGroups {

    @SerializedName("items")
    private List<VenueResultItem> venues;

    public VenueGroups(List<VenueResultItem> venues) {
        this.venues = venues;
    }

    public List<VenueResultItem> getVenues() {
        return venues;
    }
}
