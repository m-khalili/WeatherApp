
package com.mk.weather.ModelEntites.HourlyModel;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Clouds {

    @SerializedName("all")
    private Long mAll;

    public Long getAll() {
        return mAll;
    }

    public void setAll(Long all) {
        mAll = all;
    }

}
