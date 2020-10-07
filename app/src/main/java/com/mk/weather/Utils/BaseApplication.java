package com.mk.weather.Utils;

import android.app.Application;
import android.graphics.Typeface;

import androidx.appcompat.app.AlertDialog;

public class BaseApplication extends Application {
    public static BaseApplication bassApp;
    @Override
    public void onCreate() {
        super.onCreate();
        bassApp = this;



    }


}
