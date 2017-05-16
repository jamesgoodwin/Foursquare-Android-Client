package com.locationsearch;

import java.util.List;

public class VenueResultItem {

    private String name;
    private VenueLocation location;
    private List<VenueCategory> categories;

    public VenueResultItem(String name, VenueLocation location, List<VenueCategory> categories) {
        this.name = name;
        this.location = location;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public VenueLocation getLocation() {
        return location;
    }

    public List<VenueCategory> getCategories() {
        return categories;
    }
}
