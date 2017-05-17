package com.locationsearch;

import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class VenueViewHolder extends RecyclerView.ViewHolder implements VenueView {

    private final TextView venueNameText;
    private final TextView descriptionText;
    private final AppCompatRatingBar ratingBar;

    private final VenuePresenter venuePresenter;

    VenueViewHolder(View itemView, VenuePresenter venuePresenter) {
        super(itemView);
        this.venueNameText = (TextView) itemView.findViewById(R.id.venueNameText);
        this.descriptionText = (TextView) itemView.findViewById(R.id.descriptionText);
        this.ratingBar = (AppCompatRatingBar) itemView.findViewById(R.id.ratingBar);
        this.venuePresenter = venuePresenter;
    }

    void setVenue(Venue venue) {
        venuePresenter.showVenue(venue, this);
    }

    @Override
    public void showRating(float rating) {
        this.ratingBar.setRating(rating);
    }

    @Override
    public void showVenueName(String venueName) {
        this.venueNameText.setText(venueName);
    }

    @Override
    public void showVenueAddress(String address) {
        this.descriptionText.setText(address);
    }

}