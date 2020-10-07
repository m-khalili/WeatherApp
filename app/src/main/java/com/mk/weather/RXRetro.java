package com.mk.weather;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RXRetro {
    public static <S> S createService(  Class<S> serviceClass ) {

        String BASE_URL = "https://api.openweathermap.org/" ;
        //key=b8d26c545840262364751f1a601aeb5b5e689c47b426f320f6e2beeb

        HttpLoggingInterceptor loggerInterceptorBody = new HttpLoggingInterceptor();
        loggerInterceptorBody.setLevel(HttpLoggingInterceptor.Level.BODY);

        HttpLoggingInterceptor loggerInterceptorHeader = new HttpLoggingInterceptor();
        loggerInterceptorHeader.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        OkHttpClient client = (new okhttp3.OkHttpClient.Builder()).addInterceptor(loggerInterceptorBody).addInterceptor(loggerInterceptorHeader).readTimeout(30L, TimeUnit.SECONDS).connectTimeout(30L, TimeUnit.SECONDS).build();
        Retrofit retrofit = (new retrofit2.Retrofit.Builder()).baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(serviceClass);
    }

}
