package com.example.pankaj.extraaedge_assignment;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("data/2.5/{category}")
    Call<Abc> aaa(
            @Path("category") String category,
            @Query("q") String q,
            @Query("appid") String appid
    );
}
