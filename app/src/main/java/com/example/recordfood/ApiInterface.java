package com.example.recordfood;

import java.lang.reflect.Array;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/")
    Call<Food> getFoodCalorie(@Query("query") String q);
}
