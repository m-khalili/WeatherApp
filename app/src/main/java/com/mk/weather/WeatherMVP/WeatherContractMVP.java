package com.mk.weather.WeatherMVP;

import com.mk.weather.ModelEntites.CurrentModel.Datum;
import com.mk.weather.ModelEntites.HourlyModel.ListModel;
import com.mk.weather.ModelEntites.dailyModel.DailyDatum;

import java.util.List;

public interface WeatherContractMVP {

    interface View {
        void networkIsEnable();
        void networkIsDisabled();

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


        void onGetCurrentData(String city);
        void onReceivedCurrentData(List<Datum> currentData);
        void onFailed(Throwable t);
        void onGetHourly(String q);
        void onResponseHourlyData(List<ListModel> hourlyData);
        void onGetDaily(String city);
        void onResponseDailyData(List<DailyDatum> dailyData);
    }
    interface Model{
        void checkNetWorkConnection();

        void attachPresenter(Presenter presenter);
        void onGetCurrentData(String city);
        void GetHourly(String q);
        void onGetDaily(String city);
    }
}
