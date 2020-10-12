package com.mk.weather.WeatherMVP;

import com.mk.weather.ModelEntites.searchModel.SearchModel;
import com.mk.weather.ModelEntites.CurrentModel.CurrentModel;
import com.mk.weather.ModelEntites.HourlyModel.HourlyModel;
import com.mk.weather.ModelEntites.dailyModel.DailyModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherServiceInterface {
    @GET("v2.0/current?")
    Call<CurrentModel> getData(
            @Query("city") String city,

            @Query("key") String key
    );
    @GET("data/2.5/forecast?")
    Call<HourlyModel> getHourly(
            @Query("q") String q,

            @Query("appid") String appid
    );


    @GET("v2.0/forecast/daily?")
    Call<DailyModel> getDaily(
            @Query("city") String city,
            @Query("key") String key
    );
    @GET("v2.0/current?")
    Call<SearchModel> getCityDetail(
            @Query("city") String city,
            @Query("key") String key
    );


    @GET("v2.0/current?")
    Call<CurrentModel> getCityCurrentData(
            @Query("city") String city,
            @Query("key") String key
    );
}
