package com.example.covid_19updates.api;


import com.example.covid_19updates.models.Covid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidApi {

    @GET("v3/covid-19/countries")
    Call<List<Covid>> getSummary();
}
