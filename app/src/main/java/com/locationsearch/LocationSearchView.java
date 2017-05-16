package com.locationsearch;

import java.util.List;

interface LocationSearchView {

    void showLoading(boolean show);

    void showResults(List<VenueResultItem> venueResultItems);
}
