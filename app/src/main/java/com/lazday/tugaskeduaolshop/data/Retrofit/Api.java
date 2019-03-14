package com.lazday.tugaskeduaolshop.data.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    public static Retrofit getUrlTugas(){
        return new Retrofit.Builder()
                .baseUrl("https://demo.lazday.com/restserver/index.php/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
