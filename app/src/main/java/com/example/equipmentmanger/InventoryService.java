package com.example.equipmentmanger;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface InventoryService {

    @GET("login")
    Call<String> getLoginDetail(
            @Query("userEmail") String userEmail,
            @Query("userPassword") String userPassword
    );

    @POST("signup")
    Call<String> saveSignUpDetail(@Body SignUpRequest signUpRequest);

}
