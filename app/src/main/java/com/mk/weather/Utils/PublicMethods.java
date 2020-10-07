package com.mk.weather.Utils;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

import com.mk.weather.R;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class PublicMethods {


    public static String getTime(long unixTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date dt = new Date(unixTime * 1000);
        String date = dateFormat.format(dt);
        return date;
    }
    public static Object getTimezone(String time)  {
 Date inputDate = new Date();
        if (time != null && !time.isEmpty()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm" );
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            try {
                inputDate = simpleDateFormat.parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("HH:mm" );
        return simpleDateFormat1.format(inputDate);
    }

    public static String getDate(long unixTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM");
        Date dt = new Date(unixTime * 1000);
        String date = dateFormat.format(dt);
        return date;
    }


    public static String getDay(long unixTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        Date dt = new Date(unixTime * 1000);
        String date = dateFormat.format(dt);
        return date;
    }

    public static void toastT(String msg , int length) {
        Toast.makeText(BaseApplication.bassApp, msg, length).show();
    }
    public static void toast(String msg ) {
        Toast.makeText(BaseApplication.bassApp, msg,Toast.LENGTH_SHORT).show();
    }


    public static double ktoC(double k){
        return k - 273;
    }

//
//     public static String ktoC(double k) {
//
//        return String.valueOf(k - 273);
//    }

    public static String speedInMsecToKmHr(double meterSec) {
        return String.valueOf(((meterSec) * 18 / 5));
    }

    public static void setShared(Context mContext, String key, String value) {
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString(key, value).apply();
    }

    public static String getShared(Context mContext, String key, String defValue) {
        return
                PreferenceManager.getDefaultSharedPreferences(mContext).getString(key, defValue);

    }

    public static int description(String description){

        if (nightOrDay().equals(Constants.day) && description.equals(Constants.fewClouds)){
            return R.drawable.ic_clear_day;
        }else
            return R.drawable.icon_gray_bg_sunny_night;
//        if (nightOrDay().equals("day") &&description.equals(Constants.fewClouds)){
//            return R.drawable.daily_forecast_cloudy;
//        }
//        return 0;

    }
//    public static int getIcon(int code) {
//
//        if (nightOrDay().equals(Constants.day) && code == 800) {
//            return R.drawable.icon_gray_bg_sunny_night;
//        }
//        if (code == 801 || code == 802){
//            return R.drawable.icon_gray_bg_sunny_night;
//        }
//        return 0;
//    }




    public static int roundFloat(double f) {
        int c = (int) ((f) + 0.5f);
        double n = f + 0.5f;
        return (n - c) % 2 == 0 ? (int) f : c;
    }
//    public static int getDay(String date){
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
//        return dayOfWeek;
//    }

    public static boolean checkNetWorkConnection() {

        ConnectivityManager cm =
                (ConnectivityManager) BaseApplication.bassApp.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;

    }

    public static void checkGpsStatus() {
        boolean gpsStatus ;
      LocationManager  locationManager = (LocationManager) BaseApplication.bassApp.getSystemService(Context.LOCATION_SERVICE);
        assert locationManager != null;
        gpsStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (gpsStatus == true) {
            PublicMethods.toast("is on");
        } else {
            PublicMethods.toast("GPS Is Disabled");
        }
    }
    public static boolean isLocationEnabled(Context context) {
        int locationMode = 0;
        String locationProviders;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);

            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }

            return locationMode != Settings.Secure.LOCATION_MODE_OFF;

        }else{
            locationProviders = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }


    }
    public static boolean checkSharePreferencesIsExist(){
        File f = new File("/data/data/com.mk.weather/shared_prefs/com.mk.weather_preferences.xml");
        return f.exists();
    }
    public static String nightOrDay(){

    Calendar c = Calendar.getInstance();
    int timeOfDay = c.get(Calendar.HOUR_OF_DAY);
        if (timeOfDay <= 6 || timeOfDay >= 20){

            return "night";
        }else
          return "day";
    }
    public static void showFragment(Fragment fragment, FragmentManager fragmentManager) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        transaction.add(android.R.id.content, fragment).addToBackStack(null).commit();
    }
}