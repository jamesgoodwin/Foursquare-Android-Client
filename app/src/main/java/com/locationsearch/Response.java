package com.locationsearch;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("groups")
    private VenueGroups venueGroups;

    public Response(VenueGroups venueGroups) {
        this.venueGroups = venueGroups;
    }

    public VenueGroups getVenueGroups() {
        return venueGroups;
    }
}
