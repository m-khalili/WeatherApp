package com.mk.weather.Utils;
import android.content.Context;
import android.widget.Toast;
import androidx.preference.PreferenceManager;
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



    public static Double speedInMsecToKmHr(double meterSec) {
        return ((meterSec) * 18 / 5);
    }

    public static void setShared(Context mContext, String key, String value) {
        PreferenceManager.getDefaultSharedPreferences(mContext).edit().putString(key, value).apply();
    }

    public static String getShared(Context mContext, String key, String defValue) {
        return
                PreferenceManager.getDefaultSharedPreferences(mContext).getString(key, defValue);

    }

    public static int roundFloat(double f) {
        int c = (int) ((f) + 0.5f);
        double n = f + 0.5f;
        return (n - c) % 2 == 0 ? (int) f : c;
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
    public static String checkTime(String time){

        return "";
    }
}