
package com.mk.weather.WeatherMVP.HourlyModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class ListModel {

    @SerializedName("clouds")
    private Clouds mClouds;
    @SerializedName("dt")
    private Long mDt;
    @SerializedName("dt_txt")
    private String mDtTxt;
    @SerializedName("main")
    private Main mMain;
    @SerializedName("pop")
    private Object mPop;
    @SerializedName("sys")
    private Sys mSys;
    @SerializedName("visibility")
    private Long mVisibility;
    @SerializedName("weather")
    private java.util.List<Weather> mWeather;
    @SerializedName("wind")
    private Wind mWind;

    public Clouds getClouds() {
        return mClouds;
    }

    public void setClouds(Clouds clouds) {
        mClouds = clouds;
    }

    public Long getDt() {
        return mDt;
    }

    public void setDt(Long dt) {
        mDt = dt;
    }

    public String getDtTxt() {
        return mDtTxt;
    }

    public void setDtTxt(String dtTxt) {
        mDtTxt = dtTxt;
    }

    public Main getMain() {
        return mMain;
    }

    public void setMain(Main main) {
        mMain = main;
    }

    public Object getPop() {
        return mPop;
    }

    public void setPop(Object pop) {
        mPop = pop;
    }

    public Sys getSys() {
        return mSys;
    }

    public void setSys(Sys sys) {
        mSys = sys;
    }

    public Long getVisibility() {
        return mVisibility;
    }

    public void setVisibility(Long visibility) {
        mVisibility = visibility;
    }

    public java.util.List<Weather> getWeather() {
        return mWeather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        mWeather = weather;
    }

    public Wind getWind() {
        return mWind;
    }

    public void setWind(Wind wind) {
        mWind = wind;
    }

}
