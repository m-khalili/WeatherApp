package com.mk.weather.WeatherMVP;

import android.util.Log;

import com.mk.weather.WeatherMVP.CurrentModel.Datum;
import com.mk.weather.WeatherMVP.HourlyModel.ListModel;
import com.mk.weather.WeatherMVP.dailyModel.DailyDatum;

import java.util.List;

public class WeatherPresenterMVP implements WeatherContractMVP.Presenter {
    String TAG = "monitor_";
    WeatherModelMVP model = new WeatherModelMVP();
     WeatherContractMVP.View view;

    @Override
    public void attachView(WeatherContractMVP.View view) {
        this.view = view;
        model.attachPresenter(this);

    }

    @Override
    public void checkNetWorkConnection() {
        model.checkNetWorkConnection();
        Log.d(TAG, "checkNetWorkConnection: Presenter");
    }

    @Override
    public void networkIsEnable() {
        view.networkIsEnable();
        Log.d(TAG, "networkIsEnable: Presenter");
    }

    @Override
    public void networkIsDisabled() {
        view.networkIsDisabled();
        Log.d(TAG, "networkIsDisabled: presenter");
    }



//    @Override
//    public void checkGpsStatus() {
//        model.checkGpsStatus();
//        Log.d(TAG, "checkGpsStatus: presenter");
//    }
//
//    @Override
//    public void gpsIsEnable() {
//        view.gpsIsEnable();
//        Log.d(TAG, "gpsIsEnable: presenter");
//    }
//
//    @Override
//    public void gpsIsDisabled() {
//        view.gpsIsDisabled();
//        Log.d(TAG, "gpsIsDisabled: presenter");
//    }

//    @Override
//    public void getDataFromSavedLocation() {
//        view.getDataFromSavedLocation();
//    }


    @Override
    public void onFailed(Throwable t) {
        view.onFailed(t);
    }

    @Override
    public void onGetCurrentData(String city) {
        model.onGetCurrentData(city);
    }



    @Override
    public void onReceivedCurrentData(List<Datum> currentData) {
            view.onReceivedCurrentData(currentData);

    }
    @Override
    public void onGetHourly(String q) {
        model.GetHourly(q);
    }

    @Override
    public void onResponseHourlyData(List<ListModel> hourlyData) {
        view.onResponseHourlyData(hourlyData);
        Log.d(TAG, "onResponseHourlyData: presenter");
    }

    @Override
    public void onGetDaily(String city) {
        model.onGetDaily(city);
        Log.d(TAG, "onGetDaily: presenter");
    }

    @Override
    public void onResponseDailyData(List<DailyDatum> dailyData) {
        view.onResponseDailyData(dailyData);
        Log.d(TAG, "onResponseDailyData: presenter");
    }
}
