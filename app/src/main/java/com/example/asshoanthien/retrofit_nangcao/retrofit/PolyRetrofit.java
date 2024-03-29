package com.example.asshoanthien.retrofit_nangcao.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PolyRetrofit {
    public static PolyService polyService;
    public static PolyService getInstance(){
        if (polyService== null){
            Retrofit retrofit=new Retrofit.Builder().baseUrl("http://asian.dotplays.com").addConverterFactory(GsonConverterFactory.create()).build();
            polyService=retrofit.create(PolyService.class);
        }
        return polyService;
    }
}
