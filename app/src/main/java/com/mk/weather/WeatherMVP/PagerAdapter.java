package com.mk.weather.WeatherMVP;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return WeatherFragmentMVP.getInstance();
        }
        if (position==1){
            return MVPFragmentA.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
