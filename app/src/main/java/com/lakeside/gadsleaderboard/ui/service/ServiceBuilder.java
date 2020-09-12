package com.lakeside.gadsleaderboard.ui.service;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    private static Retrofit sRetrofit;
    public static final String BASE_URL = "https://gadsapi.herokuapp.com";

    //For logging purposes, ad Interceptors here
    private static HttpLoggingInterceptor logging = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);


    private static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build();


    public static Retrofit getRetrofit() {
        if( sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }

        return sRetrofit;
    }

    public static <S> S buildService(Class<S> serviceType) {
        return getRetrofit().create(serviceType);
    }
}

