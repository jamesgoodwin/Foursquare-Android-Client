package com.locationsearch;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
class VenueLocation {

    private String address;

    @SerializedName("lat")
    private double latitude;

    @SerializedName("lng")
    private double longitude;

    private String postalCode;

    private String city;

    private String state;

    private String country;

    private List<String> formattedAddress;

    VenueLocation(String address, double latitude, double longitude, String postalCode, String city, String state, String country, List<String> formattedAddress) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.formattedAddress = formattedAddress;
    }

    public String getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getFormattedAddress() {
        return formattedAddress;
    }
}
