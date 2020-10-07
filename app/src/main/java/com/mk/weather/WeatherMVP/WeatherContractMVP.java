package com.mk.weather.WeatherMVP;

import com.mk.weather.WeatherMVP.CurrentModel.Datum;
import com.mk.weather.WeatherMVP.HourlyModel.ListModel;
import com.mk.weather.WeatherMVP.dailyModel.DailyDatum;

import java.util.List;

public interface WeatherContractMVP {

    interface View {
        void networkIsEnable();
        void networkIsDisabled();
        void gpsIsEnable();
        void gpsIsDisabled();
//        void getDataFromSavedLocation();
        void onReceivedCurrentData(List<Datum> currentData);
        void onFailed(Throwable t);
        void onResponseHourlyData(List<ListModel> hourlyData);
        void onResponseDailyData(List<DailyDatum> dailyData);
    }
    interface Presenter{
        void attachView(View view);
        void checkNetWorkConnection();
        void networkIsEnable();
        void networkIsDisabled();
        void checkGpsStatus();
        void gpsIsEnable();
        void gpsIsDisabled();
//        void getDataFromSavedLocation();
        void onGetCurrentData(double lat , double lon);
        void onReceivedCurrentData(List<Datum> currentData);
        void onFailed(Throwable t);
        void onGetHourly(double lat , double lon);
        void onResponseHourlyData(List<ListModel> hourlyData);
        void onGetDaily(double lat , double lon);
        void onResponseDailyData(List<DailyDatum> dailyData);
    }
    interface Model{
        void checkNetWorkConnection();
        void checkGpsStatus();
        void attachPresenter(Presenter presenter);
        void onGetCurrentData(double lat , double lon);
        void GetHourly(double lat , double lon);
        void onGetDaily(double lat , double lon);
    }
}
