package com.mk.weather.Search;

import com.mk.weather.ModelEntites.searchModel.Datum;

import java.util.List;

public interface MVPSearchContract {

     interface View{
         void result(List<Datum> search);
         void onFailed(Throwable t);

    }

    interface Presenter{
        void attachView(View view);
        void onGetCityDetail(String city);
        void result(List<Datum> search);
        void onFailed(Throwable t);
    }

    interface Model{
         void attachPresenter(Presenter presenter);
         void onGetCityDetail(String city);
    }
}
