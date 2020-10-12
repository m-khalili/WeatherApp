
package com.mk.weather.ModelEntites.CurrentModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Datum {

    @SerializedName("app_temp")
    private Double mAppTemp;
    @SerializedName("aqi")
    private Long mAqi;
    @SerializedName("city_name")
    private String mCityName;
    @SerializedName("clouds")
    private Long mClouds;
    @SerializedName("country_code")
    private String mCountryCode;
    @SerializedName("datetime")
    private String mDatetime;
    @SerializedName("dewpt")
    private Double mDewpt;
    @SerializedName("dhi")
    private Double mDhi;
    @SerializedName("dni")
    private Double mDni;
    @SerializedName("elev_angle")
    private Double mElevAngle;
    @SerializedName("ghi")
    private Double mGhi;
    @SerializedName("h_angle")
    private Object mHAngle;
    @SerializedName("lat")
    private Double mLat;
    @SerializedName("lon")
    private Double mLon;
    @SerializedName("ob_time")
    private String mObTime;
    @SerializedName("pod")
    private String mPod;
    @SerializedName("precip")
    private Long mPrecip;
    @SerializedName("pres")
    private Double mPres;
    @SerializedName("rh")
    private Double mRh;
    @SerializedName("slp")
    private Object mSlp;
    @SerializedName("snow")
    private Long mSnow;
    @SerializedName("solar_rad")
    private Double mSolarRad;
    @SerializedName("state_code")
    private String mStateCode;
    @SerializedName("station")
    private String mStation;
    @SerializedName("sunrise")
    private String mSunrise;
    @SerializedName("sunset")
    private String mSunset;
    @SerializedName("temp")
    private Double mTemp;
    @SerializedName("timezone")
    private String mTimezone;
    @SerializedName("ts")
    private Long mTs;
    @SerializedName("uv")
    private Double mUv;
    @SerializedName("vis")
    private Long mVis;
    @SerializedName("weather")
    private Weather mWeather;
    @SerializedName("wind_cdir")
    private String mWindCdir;
    @SerializedName("wind_cdir_full")
    private String mWindCdirFull;
    @SerializedName("wind_dir")
    private Long mWindDir;
    @SerializedName("wind_spd")
    private Double mWindSpd;

    public Double getAppTemp() {
        return mAppTemp;
    }

    public void setAppTemp(Double appTemp) {
        mAppTemp = appTemp;
    }

    public Long getAqi() {
        return mAqi;
    }

    public void setAqi(Long aqi) {
        mAqi = aqi;
    }

    public String getCityName() {
        return mCityName;
    }

    public void setCityName(String cityName) {
        mCityName = cityName;
    }

    public Long getClouds() {
        return mClouds;
    }

    public void setClouds(Long clouds) {
        mClouds = clouds;
    }

    public String getCountryCode() {
        return mCountryCode;
    }

    public void setCountryCode(String countryCode) {
        mCountryCode = countryCode;
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

    public Double getDhi() {
        return mDhi;
    }

    public void setDhi(Double dhi) {
        mDhi = dhi;
    }

    public Double getDni() {
        return mDni;
    }

    public void setDni(Double dni) {
        mDni = dni;
    }

    public Double getElevAngle() {
        return mElevAngle;
    }

    public void setElevAngle(Double elevAngle) {
        mElevAngle = elevAngle;
    }

    public Double getGhi() {
        return mGhi;
    }

    public void setGhi(Double ghi) {
        mGhi = ghi;
    }

    public Object getHAngle() {
        return mHAngle;
    }

    public void setHAngle(Object hAngle) {
        mHAngle = hAngle;
    }

    public Double getLat() {
        return mLat;
    }

    public void setLat(Double lat) {
        mLat = lat;
    }

    public Double getLon() {
        return mLon;
    }

    public void setLon(Double lon) {
        mLon = lon;
    }

    public String getObTime() {
        return mObTime;
    }

    public void setObTime(String obTime) {
        mObTime = obTime;
    }

    public String getPod() {
        return mPod;
    }

    public void setPod(String pod) {
        mPod = pod;
    }

    public Long getPrecip() {
        return mPrecip;
    }

    public void setPrecip(Long precip) {
        mPrecip = precip;
    }

    public Double getPres() {
        return mPres;
    }

    public void setPres(Double pres) {
        mPres = pres;
    }

    public Double getRh() {
        return mRh;
    }

    public void setRh(Double rh) {
        mRh = rh;
    }

    public Object getSlp() {
        return mSlp;
    }

    public void setSlp(Object slp) {
        mSlp = slp;
    }



    public Long getSnow() {
        return mSnow;
    }

    public void setSnow(Long snow) {
        mSnow = snow;
    }

    public Double getSolarRad() {
        return mSolarRad;
    }

    public void setSolarRad(Double solarRad) {
        mSolarRad = solarRad;
    }

    public String getStateCode() {
        return mStateCode;
    }

    public void setStateCode(String stateCode) {
        mStateCode = stateCode;
    }

    public String getStation() {
        return mStation;
    }

    public void setStation(String station) {
        mStation = station;
    }

    public String getSunrise() {
        return mSunrise;
    }

    public void setSunrise(String sunrise) {
        mSunrise = sunrise;
    }

    public String getSunset() {
        return mSunset;
    }

    public void setSunset(String sunset) {
        mSunset = sunset;
    }

    public Double getTemp() {
        return mTemp;
    }

    public void setTemp(Double temp) {
        mTemp = temp;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
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

    public Long getVis() {
        return mVis;
    }

    public void setVis(Long vis) {
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

    public Double getWindSpd() {
        return mWindSpd;
    }

    public void setWindSpd(Double windSpd) {
        mWindSpd = windSpd;
    }

}
