package com.locationsearch;

import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import static java.lang.Math.max;

class VenueViewHolder extends RecyclerView.ViewHolder {

    private final TextView venueNameText;
    private final TextView descriptionText;
    private final AppCompatRatingBar ratingBar;

    VenueViewHolder(View itemView) {
        super(itemView);
        this.venueNameText = (TextView) itemView.findViewById(R.id.venueNameText);
        this.descriptionText = (TextView) itemView.findViewById(R.id.descriptionText);
        this.ratingBar = (AppCompatRatingBar) itemView.findViewById(R.id.ratingBar);
    }

    void setVenue(Venue venue) {
        this.venueNameText.setText(venue.getName());
        this.descriptionText.setText(venue.getLocation().getFormattedAddress());

        this.ratingBar.setRating(max(venue.getRating(), 0.1f) / 2f);
    }

}