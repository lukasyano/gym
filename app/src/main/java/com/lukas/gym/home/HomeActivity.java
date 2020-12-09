package com.lukas.gym.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lukas.gym.R;
import com.lukas.gym.details.DetailsActivity;
import com.lukas.gym.network.ApiService;
import com.lukas.gym.network.ApiServiceBuilder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeActivity extends AppCompatActivity implements GymItemClickListener{

    private final ApiService apiService = ApiServiceBuilder.getApiService();
    private final HomeAdapter homeAdapter = new HomeAdapter(this);
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setUi();
        getGyms();
    }

    private void setUi() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(homeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onGymItemClick(Object object) {
        Intent detailsIntent = new Intent(this, DetailsActivity.class);
        detailsIntent.putExtra("KEY", object.toString());

        startActivity(detailsIntent);
    }

    private void getGyms() {
        Disposable disposable = apiService.getAllGyms()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(gyms -> {
                            Log.d("GotfromNetwork", "results :" + gyms);
                            homeAdapter.setData(gyms);
                        },
                        throwable -> {
                            Log.d("GotfromNetwork", "ERROR :" + throwable.getMessage());
                        });

        compositeDisposable.add(disposable);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

}