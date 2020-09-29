package com.example.csm;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface CmInterface {

    @GET("latest")
    Call<List<Currencies>> getCurrencies();
}
