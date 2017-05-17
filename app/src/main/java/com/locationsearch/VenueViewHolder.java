package com.locationsearch;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class VenueViewHolder extends RecyclerView.ViewHolder {

    private final TextView venueNameText;

    VenueViewHolder(View itemView) {
        super(itemView);
        this.venueNameText = (TextView) itemView.findViewById(R.id.venueNameText);
    }

    void setVenue(Venue venue) {
        this.venueNameText.setText(venue.getName());
    }

}
