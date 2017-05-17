package com.jamesgoodwin.foursquareclient;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;

import com.jamesgoodwin.R;
import com.jamesgoodwin.foursquareclient.model.Venue;
import com.jamesgoodwin.foursquareclient.service.FoursquareRetrofitApiService;
import com.jamesgoodwin.foursquareclient.service.FoursquareSearchService;

import java.util.List;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;

public class LocationSearchActivity extends AppCompatActivity implements LocationSearchView {

    private LocationSearchPresenter presenter;
    private View loadingOverlay;
    private RecyclerView venuesList;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_location_search);
        setTitle(null);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(toolbar);

        loadingOverlay = findViewById(R.id.loadingOverlay);
        searchView = (SearchView) findViewById(R.id.searchView);
        venuesList = (RecyclerView) findViewById(R.id.venuesList);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.foursquare.com/v2/")
                .client(new OkHttpClient()).build();

        FoursquareRetrofitApiService apiService = retrofit.create(FoursquareRetrofitApiService.class);
        FoursquareSearchService searchService = new FoursquareSearchService(apiService);

        this.presenter = new LocationSearchPresenter(this, searchService, Schedulers.io(), mainThread());

        initialiseSearchView();
    }

    private void initialiseSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.searchVenues(query);
                hideKeyboard();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(searchView.getWindowToken(), 0);
    }

    @Override
    public void showLoading(boolean show) {
        loadingOverlay.setVisibility(show ? VISIBLE : GONE);
    }

    @Override
    public void showResults(List<Venue> venues) {
        venuesList.setAdapter(new VenueAdapter(venues));
        venuesList.setLayoutManager(new LinearLayoutManager(this));
    }
}