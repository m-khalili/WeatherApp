package com.mk.weather.Search;

import com.mk.weather.ModelEntites.searchModel.Datum;

import java.util.List;

public class MVPSearchPresenter implements MVPSearchContract.Presenter {
    MVPSearchModel model = new MVPSearchModel();
    MVPSearchContract.View view;
    @Override
    public void attachView(MVPSearchContract.View view) {
        this.view = view;
        model.attachPresenter(this);
    }

    @Override
    public void onGetCityDetail(String city) {
        model.onGetCityDetail(city);
    }

    @Override
    public void result(List<Datum> search) {
        view.result(search);
    }

    @Override
    public void onFailed(Throwable t) {
        view.onFailed(t);
    }


}
