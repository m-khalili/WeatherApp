package com.mk.weather.WeatherMVP;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.airbnb.lottie.LottieAnimationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.mk.weather.CustomView.MyTextView;
import com.mk.weather.R;
import com.mk.weather.Search.MVPSearchActivity;
import com.mk.weather.Utils.BaseActivity;
import com.mk.weather.Utils.BaseApplication;
import com.mk.weather.Utils.Constants;
import com.mk.weather.Utils.PublicMethods;
import com.mk.weather.Utils.WeatherIcon;
import com.mk.weather.WeatherMVP.CurrentModel.Datum;
import com.mk.weather.WeatherMVP.HourlyModel.ListModel;
import com.mk.weather.WeatherMVP.dailyModel.DailyDatum;

import java.util.List;

import io.nlopez.smartlocation.SmartLocation;

public class WeatherActivityMVP extends BaseActivity implements WeatherContractMVP.View, SwipeRefreshLayout.OnRefreshListener {

    String TAG = "monitor_";
    MyTextView locationName,temp,description,sunrise,sunset,realFeel,windSpeed;
    //    MyImageView icon;
    RecyclerView recycler1,recyclerDaily;
    SwipeRefreshLayout refresh;
    LottieAnimationView lottie;
    WeatherPresenterMVP presenter = new WeatherPresenterMVP();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        bind();
        permission();
        presenter.attachView(this);
        presenter.checkNetWorkConnection();
        refresh.setOnRefreshListener(this);
        Log.d(TAG, "onCreateView: ");


    }
    @Override
    public void networkIsEnable() {
        presenter.checkGpsStatus();
        Log.d(TAG, "networkIsEnable: ");
    }

    @Override
    public void networkIsDisabled() {
        PublicMethods.toastT("no Net " ,1);
    }

    @Override
    public void gpsIsEnable() {
        getLocation();
        Log.d(TAG, "gpsIsEnable: ");
    }

    @Override
    public void gpsIsDisabled() {
        if (PublicMethods.checkSharePreferencesIsExist()){
            getDataFromSavedLocation();
        }else
            turnOnGPS();
    }

    private void turnOnGPS() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.turn_on_gps)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        PublicMethods.toast("cancel");
                    }
                })
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        getLocation();
                    }
                });

        builder.create().show();
    }



    public void getDataFromSavedLocation() {
        String latitude = PublicMethods.getShared(BaseApplication.bassApp,"lat" , "");
        String longitude = PublicMethods.getShared(BaseApplication.bassApp,"lon" , "");
        if (latitude != null && longitude != null) {
            double lat = (Double.parseDouble(latitude));
            double lon = (Double.parseDouble(longitude));
            presenter.onGetCurrentData(lat,lon);
            presenter.onGetHourly(lat,lon);
            presenter.onGetDaily(lat,lon);

        }
    }

    @Override
    public void onReceivedCurrentData(List<Datum> currentData) {
        if (currentData != null && currentData.size() > 0) {
            for (int i = 0; i < currentData.size(); i++) {
                locationName.setTxt(currentData.get(i).getCityName());
                temp.setTxt(PublicMethods.roundFloat(currentData.get(i).getTemp())+ Constants.c);
                description.setTxt(currentData.get(i).getWeather().getDescription());
                lottie.loop(true);
                lottie.setAnimation(WeatherIcon.getIconLottie(currentData.get(i).getWeather().getCode()));
                sunrise.setTxt(String.valueOf(PublicMethods.getTimezone(currentData.get(i).getSunrise())));
                sunset.setTxt(String.valueOf(PublicMethods.getTimezone(currentData.get(i).getSunset())));
                realFeel.setTxt(PublicMethods.roundFloat(currentData.get(i).getAppTemp())+Constants.c);
                windSpeed.setTxt(currentData.get(i).getWindSpd());
            }
        }
    }

    @Override
    public void onFailed(Throwable t) {
        PublicMethods.toastT(t.toString() , 1);
    }

    @Override
    public void onResponseHourlyData(List<ListModel> hourlyData) {
        RecyclerAdapterHourly adapterHourly = new RecyclerAdapterHourly(hourlyData , BaseApplication.bassApp);
        recycler1.setAdapter(adapterHourly);
    }

    @Override
    public void onResponseDailyData(List<DailyDatum> dailyData) {
        RecyclerAdapterDailyForecast adapter = new RecyclerAdapterDailyForecast(dailyData , BaseApplication.bassApp);
        recyclerDaily.setAdapter(adapter);
//        Log.d(TAG, "onResponseDailyData: view ");
    }
    private void getLocation(){

        SmartLocation.with(BaseApplication.bassApp).location().start(L -> {
            double lat = L.getLatitude();
            double lon = L.getLongitude();
            PublicMethods.setShared(BaseApplication.bassApp , "lat" , String.valueOf(lat));
            PublicMethods.setShared(BaseApplication.bassApp , "lon" , String.valueOf(lon));
            presenter.onGetCurrentData(lat,lon);
            presenter.onGetHourly(lat,lon);
            presenter.onGetDaily(lat,lon);
            Log.d(TAG, "getLocation: ");

        });
    }

    void bind(){
        locationName = findViewById(R.id.locationName);
        description = findViewById(R.id.description);
        temp = findViewById(R.id.temp);
        sunrise = findViewById(R.id.sunrise);
        sunset = findViewById(R.id.sunset);
        realFeel = findViewById(R.id.realFeel);
        windSpeed = findViewById(R.id.windSpeed);
//        icon = v.findViewById(R.id.icon);
        recycler1 =findViewById(R.id.recycler1);
        recyclerDaily = findViewById(R.id.recyclerDaily);
        refresh = findViewById(R.id.refresh);
        lottie = findViewById(R.id.lottie);


        findViewById(R.id.searchCity).setOnClickListener(V->{
            Intent intent = new Intent(BaseApplication.bassApp , MVPSearchActivity.class);
            startActivityForResult(intent,1000);
        });

    }
    private void permission(){
        Dexter.withContext(this)
                .withPermissions(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                ).withListener(new MultiplePermissionsListener() {
            @Override public void onPermissionsChecked(MultiplePermissionsReport report) {}
            @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {}
        }).check();
    }

    @Override
    public void onRefresh() {

        presenter.checkNetWorkConnection();
        refresh.setRefreshing(false);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000){
            if (resultCode == Activity.RESULT_OK){
                String  result = data.getStringExtra(Constants.cityName);
//                presenter.onGetCurrentData(result);
                PublicMethods.toastT(result, 1);

            }
        }
    }
}
