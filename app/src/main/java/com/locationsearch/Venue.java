package com.locationsearch;

class Venue {

    private String name;
    private VenueLocation location;
    private float rating;

    public Venue(String name, VenueLocation location, float rating) {
        this.name = name;
        this.location = location;
        this.rating = rating;
    }

    public float getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public VenueLocation getLocation() {
        return location;
    }
}