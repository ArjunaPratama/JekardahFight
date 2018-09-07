package com.arjuna.jekardahfight.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arjuna on 07/09/18.
 */

public class InstanceRetrofit {
    public static  final  String url = "http://api.jakarta.go.id/v1/emergency/petugaspemadam";
    public static Retrofit setInit(){
        return new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiService getInstance() {
        return setInit().create(ApiService.class);
    }
}
