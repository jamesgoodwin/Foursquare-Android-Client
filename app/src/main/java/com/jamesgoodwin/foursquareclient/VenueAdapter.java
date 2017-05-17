package com.jamesgoodwin.foursquareclient;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.jamesgoodwin.R;
import com.jamesgoodwin.foursquareclient.model.Venue;

import java.util.List;

class VenueAdapter extends RecyclerView.Adapter<VenueViewHolder> {

    private final List<Venue> venues;

    public VenueAdapter(List<Venue> venues) {
        this.venues = venues;
    }

    @Override
    public VenueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        return new VenueViewHolder(inflater.inflate(R.layout.layout_venue, parent, false), new VenuePresenter());
    }

    @Override
    public void onBindViewHolder(VenueViewHolder holder, int position) {
        holder.setVenue(venues.get(position));
    }

    @Override
    public int getItemCount() {
        return venues.size();
    }
}
