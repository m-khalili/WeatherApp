package com.mk.weather.WeatherMVP;

import com.mk.weather.Search.searchModel.SearchModel;
import com.mk.weather.WeatherMVP.CurrentModel.CurrentModel;
import com.mk.weather.WeatherMVP.HourlyModel.HourlyModel;
import com.mk.weather.WeatherMVP.dailyModel.DailyModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherServiceInterface {
    @GET("v2.0/current?")
    Call<CurrentModel> getData(
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("key") String key
    );
    @GET("data/2.5/forecast?")
    Call<HourlyModel> getHourly(
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("appid") String appid
    );


    @GET("v2.0/forecast/daily?")
    Call<DailyModel> getDaily(
            @Query("lat") double lat,
            @Query("lon") double lon,
            @Query("key") String key
    );
    @GET("v2.0/current?")
    Call<SearchModel> getCityDetail(
            @Query("city") String city,
            @Query("key") String key
    );

//
//    @GET("v2.0/forecast/daily?")
//    Observable<DailyModel> getDailyData(
//            @Query("lat") double lat,
//            @Query("lon") double lon,
//            @Query("key") String key
//    );

    @GET("v2.0/current?")
    Call<CurrentModel> getCityCurrentData(
            @Query("city") String city,
            @Query("key") String key
    );
}