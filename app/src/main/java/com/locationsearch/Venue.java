package com.locationsearch;

@SuppressWarnings("unused")
class Venue {

    private String name;
    private VenueLocation location;

    public Venue(String name, VenueLocation location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public VenueLocation getLocation() {
        return location;
    }
}