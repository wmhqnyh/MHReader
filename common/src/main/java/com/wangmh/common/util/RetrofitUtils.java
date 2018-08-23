package com.wangmh.common.util;

import com.wangmh.common.http.RetrofitService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    private static final int DEFAULT_TIMEOUT = 10;
    private static final String BASE_URL = RetrofitService.BASE_URL;;
    private static String TAG = RetrofitUtils.class.getSimpleName();

    private static volatile RetrofitUtils retrofitUtils;
    private Retrofit retrofit;
    private RetrofitService retrofitService;

    private static RetrofitUtils getInstance(){
        if (null == retrofitUtils){
            synchronized (RetrofitUtils.class) {
                if (null  == retrofitUtils){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    public RetrofitUtils() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        retrofitService = retrofit.create(RetrofitService.class);
    }
}
