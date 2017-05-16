package com.locationsearch;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

class VenueAdapter extends RecyclerView.Adapter<VenueViewHolder> {

    private final List<VenueResultItem> venueResultItems;

    VenueAdapter(List<VenueResultItem> venueResultItems) {
        this.venueResultItems = venueResultItems;
    }

    @Override
    public VenueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        return new VenueViewHolder(inflater.inflate(R.layout.layout_venue, parent, false));
    }

    @Override
    public void onBindViewHolder(VenueViewHolder holder, int position) {
        holder.setVenue(venueResultItems.get(position));
    }

    @Override
    public int getItemCount() {
        return venueResultItems.size();
    }
}
