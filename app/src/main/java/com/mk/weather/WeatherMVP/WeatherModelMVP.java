package com.mk.weather.WeatherMVP;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.mk.weather.RXRetro;
import com.mk.weather.Utils.BaseApplication;
import com.mk.weather.Utils.Constants;
import com.mk.weather.Utils.PublicMethods;
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
    Context context;
    WeatherContractMVP.Presenter presenter;
    LocationManager manager = (LocationManager) BaseApplication.bassApp.getSystemService(Context.LOCATION_SERVICE);
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
    public void checkGpsStatus() {
       if (PublicMethods.isLocationEnabled(BaseApplication.bassApp)){
            presenter.gpsIsEnable();
       }else
         presenter.gpsIsDisabled();
    }


//        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ){
//
//        presenter.gpsIsDisabled();
//        Log.d(TAG, "checkGpsStatus: model gps disable");
//    }else
//    checkSharePreferencesIsExist();
//        Log.d(TAG, "checkGpsStatus: model gps is enable");


    @Override
    public void onGetCurrentData(double lat , double lon) {

        serviceInterface.getData(lat,lon, Constants.key).enqueue(new Callback<CurrentModel>() {
            @Override
            public void onResponse(Call<CurrentModel> call, Response<CurrentModel> response) {
                if (response.body()!= null && response.isSuccessful()){
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
    public void GetHourly(double lat, double lon) {
        WeatherServiceInterface serviceInterface1 = RXRetro.createService(WeatherServiceInterface.class);
        serviceInterface1.getHourly(lat,lon,Constants.hourlyApiKey).enqueue(new Callback<HourlyModel>() {
            @Override
            public void onResponse(Call<HourlyModel> call, Response<HourlyModel> response) {
                if (response.body()!= null && response.isSuccessful()){
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
    public void onGetDaily(double lat, double lon) {
        serviceInterface.getDaily(lat,lon,Constants.key).enqueue(new Callback<DailyModel>() {
            @Override
            public void onResponse(Call<DailyModel> call, Response<DailyModel> response) {
                if (response.body()!= null && response.isSuccessful()){
                    List<DailyDatum> dailyData = response.body().getData();
                    presenter.onResponseDailyData(dailyData);
                    Log.d(TAG, "onResponse: model");
                }
            }

            @Override
            public void onFailure(Call<DailyModel> call, Throwable t) {
                presenter.onFailed(t);
                Log.d(TAG, "onFailure: model");
                Toast.makeText(BaseApplication.bassApp, t.toString(), Toast.LENGTH_LONG).show();

            }
        });
    }

}
