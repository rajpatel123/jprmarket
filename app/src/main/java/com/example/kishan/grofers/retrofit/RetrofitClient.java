package com.example.kishan.grofers.retrofit;

import com.camtrack.tracker.BuildConfig;
import com.camtrack.tracker.retrofit.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static ApiInterface sRetrofitClient;
    private static ApiInterface sRetrofitRxClient;

    static {
        sRetrofitClient = getRetrofit(false).create(ApiInterface.class);
        sRetrofitRxClient = getRetrofit(true).create(ApiInterface.class);
    }

    public static ApiInterface getClient() {
        synchronized (RetrofitClient.class) {
            if (sRetrofitClient == null) {
                sRetrofitClient = getRetrofit(false).create(ApiInterface.class);
            }
        }
        return sRetrofitClient;
    }

    public static ApiInterface getRxClient() {
        synchronized (RetrofitClient.class) {
            if (sRetrofitRxClient == null) {
                sRetrofitRxClient = getRetrofit(true).create(ApiInterface.class);
            }
        }
        return sRetrofitRxClient;
    }

    private static OkHttpClient okHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(60, TimeUnit.SECONDS);
        builder.readTimeout(60, TimeUnit.SECONDS);
        builder.writeTimeout(60, TimeUnit.SECONDS);

        if (BuildConfig.DEBUG) {
            // set your desired log level
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
        }
        return builder.build();
    }

    private static Retrofit getRetrofit(boolean withRxJavaSupport) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(okHttp());
        builder.baseUrl(BuildConfig.API_SERVER_IP);
        builder.addConverterFactory(GsonConverterFactory.create(gson()));
        if (withRxJavaSupport) {
            builder.addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()));
        }
        return builder.build();
    }

    public static Gson gson() {
        return new GsonBuilder().setDateFormat("yyyy-M  M-dd'T'HH:mm:ssZ").create();
    }
}