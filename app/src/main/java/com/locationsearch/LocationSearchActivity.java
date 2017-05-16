package com.locationsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.SearchView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_location_search);
        setTitle(null);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(toolbar);

        this.loadingOverlay = findViewById(R.id.loadingOverlay);
        this.venuesList = (RecyclerView) findViewById(R.id.venuesList);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.foursquare.com/v2/")
                .client(new OkHttpClient())
                .build();

        FoursquareRetrofitSearchService apiService = retrofit.create(FoursquareRetrofitSearchService.class);
        FoursquareSearchService searchService = new FoursquareSearchService(apiService);

        this.presenter = new LocationSearchPresenter(this, searchService, Schedulers.io(), mainThread());

        initialiseSearchView();
    }

    private void initialiseSearchView() {
        SearchView searchView = (SearchView) findViewById(R.id.searchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                presenter.searchVenues(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void showLoading(boolean show) {
        loadingOverlay.setVisibility(show ? VISIBLE : GONE);
    }

    @Override
    public void showResults(List<VenueResultItem> venueResultItems) {
        venuesList.setAdapter(new VenueAdapter(venueResultItems));
        venuesList.setLayoutManager(new LinearLayoutManager(this));
    }
}