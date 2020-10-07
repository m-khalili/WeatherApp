package com.mk.weather;

import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.mk.weather.Utils.BaseActivity;
import com.mk.weather.WeatherMVP.PagerAdapter;
import com.mk.weather.WeatherMVP.WeatherServiceInterface;
import com.mk.weather.WeatherMVP.dailyModel.DailyDatum;
import com.mk.weather.WeatherMVP.dailyModel.DailyModel;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.List;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;


public class MainActivity extends BaseActivity {

ViewPager main_pager;
SmartTabLayout indicator;
String TAG = "ck";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_pager = findViewById(R.id.main_pager);
        indicator = findViewById(R.id.indicator);

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        main_pager.setAdapter(adapter);
        indicator.setViewPager(main_pager);
    }

}
