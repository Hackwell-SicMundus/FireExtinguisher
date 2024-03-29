package com.example.equipmentmanger;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(45, TimeUnit.SECONDS) // connect timeout
                .writeTimeout(45, TimeUnit.SECONDS) // write timeout
                .readTimeout(45, TimeUnit.SECONDS).addInterceptor(httpLoggingInterceptor);

        OkHttpClient okHttpClient = builder.build();

        //     OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        //    okHttpClient.setConnectTimeout(30, TimeUnit.SECONDS); // connect timeout
        //    okHttpClient.setReadTimeout(30, TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://172.105.38.73:5000/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public static InventoryService getInventoryService(){
        InventoryService InventoryService = getRetrofit().create(InventoryService.class);

        return InventoryService;

    }

}
