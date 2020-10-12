package com.mk.weather.WeatherMVP;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.mk.weather.RetroGenerator;
import com.mk.weather.Utils.BaseApplication;
import com.mk.weather.Utils.Constants;
import com.mk.weather.WeatherMVP.CurrentModel.CurrentModel;
import com.mk.weather.WeatherMVP.CurrentModel.Datum;
import com.mk.weather.WeatherMVP.HourlyModel.HourlyModel;
import com.mk.weather.WeatherMVP.HourlyModel.ListModel;
import com.mk.weather.WeatherMVP.dailyModel.DailyDatum;
import com.mk.weather.WeatherMVP.dailyModel.DailyModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WeatherModelMVP implements WeatherContractMVP.Model {
    WeatherContractMVP.Presenter presenter;
    WeatherServiceInterface serviceInterface = RetrofitGenerator.createService(WeatherServiceInterface.class);
    String TAG = "monitor_";

    @Override
    public void attachPresenter(WeatherContractMVP.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void checkNetWorkConnection() {

        ConnectivityManager cm =
                (ConnectivityManager) BaseApplication.bassApp.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        if (!isConnected) {
            presenter.networkIsDisabled();
        } else
            presenter.networkIsEnable();
        Log.d(TAG, "checkNetWorkConnection: model");
    }


    @Override
    public void onGetCurrentData(String city) {

        serviceInterface.getData(city, Constants.key).enqueue(new Callback<CurrentModel>() {
            @Override
            public void onResponse(Call<CurrentModel> call, Response<CurrentModel> response) {
                if (response.body() != null && response.isSuccessful()) {
                    List<Datum> currentData = response.body().getData();
                    presenter.onReceivedCurrentData(currentData);
                    Log.d(TAG, "onResponse: model");

                }
            }

            @Override
            public void onFailure(Call<CurrentModel> call, Throwable t) {
                presenter.onFailed(t);
            }
        });
    }

    @Override
    public void GetHourly(String q) {
        WeatherServiceInterface serviceInterface1 = RetroGenerator.createService(WeatherServiceInterface.class);
        serviceInterface1.getHourly(q, Constants.hourlyApiKey).enqueue(new Callback<HourlyModel>() {
            @Override
            public void onResponse(Call<HourlyModel> call, Response<HourlyModel> response) {
                if (response.body() != null && response.isSuccessful()) {
                    List<ListModel> hourlyData = response.body().getList();
                    presenter.onResponseHourlyData(hourlyData);

                }
            }

            @Override
            public void onFailure(Call<HourlyModel> call, Throwable t) {
                presenter.onFailed(t);
            }
        });
    }

    @Override
    public void onGetDaily(String city) {
        serviceInterface.getDaily(city, Constants.key).enqueue(new Callback<DailyModel>() {
            @Override
            public void onResponse(Call<DailyModel> call, Response<DailyModel> response) {
                if (response.body() != null && response.isSuccessful()) {
                    List<DailyDatum> dailyData = response.body().getData();
                    presenter.onResponseDailyData(dailyData);
                    Log.d(TAG, "onResponse: model");
                }
            }

            @Override
            public void onFailure(Call<DailyModel> call, Throwable t) {
                presenter.onFailed(t);
                Log.d(TAG, "onFailure: model");

            }
        });
    }

}
