
package com.mk.weather.ModelEntites.HourlyModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Sys {

    @SerializedName("pod")
    private String mPod;

    public String getPod() {
        return mPod;
    }

    public void setPod(String pod) {
        mPod = pod;
    }

}
