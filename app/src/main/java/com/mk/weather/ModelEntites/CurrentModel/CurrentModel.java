
package com.mk.weather.ModelEntites.CurrentModel;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class CurrentModel {

    @SerializedName("count")
    private Long mCount;
    @SerializedName("data")
    private List<Datum> mData;

    public Long getCount() {
        return mCount;
    }

    public void setCount(Long count) {
        mCount = count;
    }

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        mData = data;
    }

}
