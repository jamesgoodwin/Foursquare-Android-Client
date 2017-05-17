package com.jamesgoodwin.foursquareclient.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

    @SerializedName("groups")
    private List<VenueGroup> venueGroups;

    public Response(List<VenueGroup> venueGroups) {
        this.venueGroups = venueGroups;
    }

    List<VenueGroup> getVenueGroups() {
        return venueGroups;
    }

}