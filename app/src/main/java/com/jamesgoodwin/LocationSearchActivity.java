package com.jamesgoodwin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LocationSearchActivity extends AppCompatActivity implements LocationSearchView {

    private LocationSearchPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_location_search);
        setTitle(null);

        Toolbar toolbar = (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(toolbar);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://api.foursquare.com/v2")
                .client(new OkHttpClient())
                .build();

        FoursquareRetrofitSearchService apiService = retrofit.create(FoursquareRetrofitSearchService.class);

        this.presenter = new LocationSearchPresenter(this, new FoursquareSearchService(apiService));

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
}
