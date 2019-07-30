package com.example.asshoanthien.retrofit_nangcao.retrofit;

import com.example.asshoanthien.retrofit_nangcao.model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PolyService {
    //http://asian.dotplays.com/wp-json/wp/v2/categories?page=1& per_page=5
    @GET("wp-json/wp/v2/categories")
    Call<List<Example>> getCategpries(@Query("page") int page, @Query("per_page") int per_page);

}
