package com.mk.weather.WeatherMVP;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
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

public class WeatherActivityMVP extends BaseActivity implements WeatherContractMVP.View, SwipeRefreshLayout.OnRefreshListener,PopupMenu.OnMenuItemClickListener {

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
        if (PublicMethods.nightOrDay()== Constants.day){
            setContentView(R.layout.activity_weather_day);
        }else
            setContentView(R.layout.activity_weather_nigh);

        bind();
        presenter.attachView(this);
        refresh.setOnRefreshListener(this);
        presenter.checkNetWorkConnection();
        Log.d(TAG, "onCreateView: ");
    }
    @Override
    public void networkIsEnable() {
        getDataFromSavedLocation();
        Log.d(TAG, "networkIsEnable: ");
    }

    @Override
    public void networkIsDisabled() {
        PublicMethods.toastT("Please Check Your Connection " ,1);
    }


    public void getDataFromSavedLocation() {
        String city = PublicMethods.getShared(BaseApplication.bassApp,"city" , "");
        if (city != null) {
            presenter.onGetCurrentData(city);
            presenter.onGetHourly(city);
            presenter.onGetDaily(city);

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
                windSpeed.setTxt(PublicMethods.roundFloat(currentData.get(i).getWindSpd()));
            }
        }
    }

    @Override
    public void onFailed(Throwable t) {
        Log.d(TAG, "onFailed: " + t);
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
    }

    void bind(){
        locationName = findViewById(R.id.locationName);
        description = findViewById(R.id.description);
        temp = findViewById(R.id.temp);
        sunrise = findViewById(R.id.sunrise);
        sunset = findViewById(R.id.sunset);
        realFeel = findViewById(R.id.realFeel);
        windSpeed = findViewById(R.id.windSpeed);
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
                PublicMethods.setShared(BaseApplication.bassApp , "city" ,result);
                presenter.onGetCurrentData(result);
                presenter.onGetHourly(result);
                presenter.onGetDaily(result);

            }
        }
    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_item, popup.getMenu());
        popup.show();
        popup.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/mrmkh/WeatherApp"));
            startActivity(intent);
        }
        return false;
    }
}
