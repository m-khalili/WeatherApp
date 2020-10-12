
package com.mk.weather.ModelEntites.dailyModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class DailyDatum {

    @SerializedName("app_max_temp")
    private Double mAppMaxTemp;
    @SerializedName("app_min_temp")
    private Double mAppMinTemp;
    @SerializedName("clouds")
    private Long mClouds;
    @SerializedName("clouds_hi")
    private Long mCloudsHi;
    @SerializedName("clouds_low")
    private Long mCloudsLow;
    @SerializedName("clouds_mid")
    private Long mCloudsMid;
    @SerializedName("datetime")
    private String mDatetime;
    @SerializedName("dewpt")
    private Double mDewpt;
    @SerializedName("high_temp")
    private Double mHighTemp;
    @SerializedName("low_temp")
    private Double mLowTemp;
    @SerializedName("max_dhi")
    private Object mMaxDhi;
    @SerializedName("max_temp")
    private Double mMaxTemp;
    @SerializedName("min_temp")
    private Double mMinTemp;
    @SerializedName("moon_phase")
    private Double mMoonPhase;
    @SerializedName("moon_phase_lunation")
    private Double mMoonPhaseLunation;
    @SerializedName("moonrise_ts")
    private Long mMoonriseTs;
    @SerializedName("moonset_ts")
    private Long mMoonsetTs;
    @SerializedName("ozone")
    private Double mOzone;
    @SerializedName("pop")
    private Long mPop;
    @SerializedName("pres")
    private Double mPres;
    @SerializedName("rh")
    private Long mRh;
    @SerializedName("slp")
    private Double mSlp;
    @SerializedName("snow")
    private Long mSnow;
    @SerializedName("snow_depth")
    private Long mSnowDepth;
    @SerializedName("sunrise_ts")
    private Long mSunriseTs;
    @SerializedName("sunset_ts")
    private Long mSunsetTs;
    @SerializedName("temp")
    private Double mTemp;
    @SerializedName("ts")
    private Long mTs;
    @SerializedName("uv")
    private Double mUv;
    @SerializedName("valid_date")
    private String mValidDate;
    @SerializedName("vis")
    private Double mVis;
    @SerializedName("weather")
    private Weather mWeather;
    @SerializedName("wind_cdir")
    private String mWindCdir;
    @SerializedName("wind_cdir_full")
    private String mWindCdirFull;
    @SerializedName("wind_dir")
    private Long mWindDir;
    @SerializedName("wind_gust_spd")
    private Double mWindGustSpd;
    @SerializedName("wind_spd")
    private Double mWindSpd;

    public Double getAppMaxTemp() {
        return mAppMaxTemp;
    }

    public void setAppMaxTemp(Double appMaxTemp) {
        mAppMaxTemp = appMaxTemp;
    }

    public Double getAppMinTemp() {
        return mAppMinTemp;
    }

    public void setAppMinTemp(Double appMinTemp) {
        mAppMinTemp = appMinTemp;
    }

    public Long getClouds() {
        return mClouds;
    }

    public void setClouds(Long clouds) {
        mClouds = clouds;
    }

    public Long getCloudsHi() {
        return mCloudsHi;
    }

    public void setCloudsHi(Long cloudsHi) {
        mCloudsHi = cloudsHi;
    }

    public Long getCloudsLow() {
        return mCloudsLow;
    }

    public void setCloudsLow(Long cloudsLow) {
        mCloudsLow = cloudsLow;
    }

    public Long getCloudsMid() {
        return mCloudsMid;
    }

    public void setCloudsMid(Long cloudsMid) {
        mCloudsMid = cloudsMid;
    }

    public String getDatetime() {
        return mDatetime;
    }

    public void setDatetime(String datetime) {
        mDatetime = datetime;
    }

    public Double getDewpt() {
        return mDewpt;
    }

    public void setDewpt(Double dewpt) {
        mDewpt = dewpt;
    }

    public Double getHighTemp() {
        return mHighTemp;
    }

    public void setHighTemp(Double highTemp) {
        mHighTemp = highTemp;
    }

    public Double getLowTemp() {
        return mLowTemp;
    }

    public void setLowTemp(Double lowTemp) {
        mLowTemp = lowTemp;
    }

    public Object getMaxDhi() {
        return mMaxDhi;
    }

    public void setMaxDhi(Object maxDhi) {
        mMaxDhi = maxDhi;
    }

    public Double getMaxTemp() {
        return mMaxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        mMaxTemp = maxTemp;
    }

    public Double getMinTemp() {
        return mMinTemp;
    }

    public void setMinTemp(Double minTemp) {
        mMinTemp = minTemp;
    }

    public Double getMoonPhase() {
        return mMoonPhase;
    }

    public void setMoonPhase(Double moonPhase) {
        mMoonPhase = moonPhase;
    }

    public Double getMoonPhaseLunation() {
        return mMoonPhaseLunation;
    }

    public void setMoonPhaseLunation(Double moonPhaseLunation) {
        mMoonPhaseLunation = moonPhaseLunation;
    }

    public Long getMoonriseTs() {
        return mMoonriseTs;
    }

    public void setMoonriseTs(Long moonriseTs) {
        mMoonriseTs = moonriseTs;
    }

    public Long getMoonsetTs() {
        return mMoonsetTs;
    }

    public void setMoonsetTs(Long moonsetTs) {
        mMoonsetTs = moonsetTs;
    }

    public Double getOzone() {
        return mOzone;
    }

    public void setOzone(Double ozone) {
        mOzone = ozone;
    }

    public Long getPop() {
        return mPop;
    }

    public void setPop(Long pop) {
        mPop = pop;
    }


    public Double getPres() {
        return mPres;
    }

    public void setPres(Double pres) {
        mPres = pres;
    }

    public Long getRh() {
        return mRh;
    }

    public void setRh(Long rh) {
        mRh = rh;
    }

    public Double getSlp() {
        return mSlp;
    }

    public void setSlp(Double slp) {
        mSlp = slp;
    }

    public Long getSnow() {
        return mSnow;
    }

    public void setSnow(Long snow) {
        mSnow = snow;
    }

    public Long getSnowDepth() {
        return mSnowDepth;
    }

    public void setSnowDepth(Long snowDepth) {
        mSnowDepth = snowDepth;
    }

    public Long getSunriseTs() {
        return mSunriseTs;
    }

    public void setSunriseTs(Long sunriseTs) {
        mSunriseTs = sunriseTs;
    }

    public Long getSunsetTs() {
        return mSunsetTs;
    }

    public void setSunsetTs(Long sunsetTs) {
        mSunsetTs = sunsetTs;
    }

    public Double getTemp() {
        return mTemp;
    }

    public void setTemp(Double temp) {
        mTemp = temp;
    }

    public Long getTs() {
        return mTs;
    }

    public void setTs(Long ts) {
        mTs = ts;
    }

    public Double getUv() {
        return mUv;
    }

    public void setUv(Double uv) {
        mUv = uv;
    }

    public String getValidDate() {
        return mValidDate;
    }

    public void setValidDate(String validDate) {
        mValidDate = validDate;
    }

    public Double getVis() {
        return mVis;
    }

    public void setVis(Double vis) {
        mVis = vis;
    }

    public Weather getWeather() {
        return mWeather;
    }

    public void setWeather(Weather weather) {
        mWeather = weather;
    }

    public String getWindCdir() {
        return mWindCdir;
    }

    public void setWindCdir(String windCdir) {
        mWindCdir = windCdir;
    }

    public String getWindCdirFull() {
        return mWindCdirFull;
    }

    public void setWindCdirFull(String windCdirFull) {
        mWindCdirFull = windCdirFull;
    }

    public Long getWindDir() {
        return mWindDir;
    }

    public void setWindDir(Long windDir) {
        mWindDir = windDir;
    }

    public Double getWindGustSpd() {
        return mWindGustSpd;
    }

    public void setWindGustSpd(Double windGustSpd) {
        mWindGustSpd = windGustSpd;
    }

    public Double getWindSpd() {
        return mWindSpd;
    }

    public void setWindSpd(Double windSpd) {
        mWindSpd = windSpd;
    }

}
