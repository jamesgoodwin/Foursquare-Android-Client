package com.locationsearch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VenueGroup {

    @SerializedName("items")
    private List<VenueResultItem> venues;

    public VenueGroup(List<VenueResultItem> venues) {
        this.venues = venues;
    }

    public List<VenueResultItem> getVenues() {
        return venues;
    }
}