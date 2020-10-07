package com.mk.weather.Search;

import com.mk.weather.Search.searchModel.Datum;
import com.mk.weather.Search.searchModel.SearchModel;
import com.mk.weather.Utils.Constants;
import com.mk.weather.WeatherMVP.RetrofitGenerator;
import com.mk.weather.WeatherMVP.WeatherServiceInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MVPSearchModel implements MVPSearchContract.Model {
    MVPSearchContract.Presenter presenter;
    WeatherServiceInterface serviceInterface = RetrofitGenerator.createService(WeatherServiceInterface.class);

    @Override
    public void attachPresenter(MVPSearchContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onGetCityDetail(String city) {
        serviceInterface.getCityDetail(city , Constants.key).enqueue(new Callback<SearchModel>() {
            @Override
            public void onResponse(Call<SearchModel> call, Response<SearchModel> response) {

                if (response.body()!= null && response.isSuccessful()){
                    List<Datum> getCityDetail = response.body().getData();
                    presenter.result(getCityDetail);
                }
            }

            @Override
            public void onFailure(Call<SearchModel> call, Throwable t) {
                presenter.onFailed( t);

            }
        });
    }
}
