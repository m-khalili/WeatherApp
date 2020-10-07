package com.mk.weather;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroGenerator {

    public static <S> S createService(  Class<S> serviceClass ) {

        String BASE_URL = "https://api.openweathermap.org/" ;

        HttpLoggingInterceptor loggerInterceptorBody = new HttpLoggingInterceptor();
        loggerInterceptorBody.setLevel(HttpLoggingInterceptor.Level.BODY);

        HttpLoggingInterceptor loggerInterceptorHeader = new HttpLoggingInterceptor();
        loggerInterceptorHeader.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        OkHttpClient client = (new okhttp3.OkHttpClient.Builder()).addInterceptor(loggerInterceptorBody).addInterceptor(loggerInterceptorHeader).readTimeout(30L, TimeUnit.SECONDS).connectTimeout(30L, TimeUnit.SECONDS).build();
        Retrofit retrofit = (new retrofit2.Retrofit.Builder()).baseUrl(BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(serviceClass);
    }


}
