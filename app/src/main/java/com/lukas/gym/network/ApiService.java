package com.lukas.gym.network;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET(".")
    Observable<ArrayList<Object>> getAllGyms();
}
