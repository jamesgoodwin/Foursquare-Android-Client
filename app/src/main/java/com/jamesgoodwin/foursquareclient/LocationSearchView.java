package com.jamesgoodwin.foursquareclient;

import com.jamesgoodwin.foursquareclient.model.Venue;

import java.util.List;

public interface LocationSearchView {

    void showLoading(boolean show);

    void showResults(List<Venue> venues);
}
