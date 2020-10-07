package com.mk.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jakewharton.rxbinding3.widget.RxTextView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.mk.weather.CustomView.MyEditText;
import com.mk.weather.CustomView.MyTextView;
import com.mk.weather.Utils.BaseApplication;
import com.mk.weather.Utils.PublicMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.nlopez.smartlocation.SmartLocation;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    MyEditText myTxt;
    MyTextView txtView;
String TAG = "share";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myTxt = findViewById(R.id.myTxt);
        txtView = findViewById(R.id.txtView);

        findViewById(R.id.btn).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this , MainActivity.class);
    }
}