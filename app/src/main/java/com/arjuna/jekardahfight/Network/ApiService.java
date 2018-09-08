package com.arjuna.jekardahfight.Network;

import com.arjuna.jekardahfight.Model.ResponseJakFight;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by arjuna on 07/09/18.
 */

public interface ApiService {
    @GET("petugaspemadam")
    Call<ResponseJakFight> requestPostPetugas(
      @Header("Authorization") String authorization
    );
}
