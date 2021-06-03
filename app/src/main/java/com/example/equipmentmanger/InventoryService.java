package com.example.equipmentmanger;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface InventoryService {

    @GET("login")
    Call<List<LoginResponse>> getLoginDetail(
            @Query("username") String userEmail,
            @Query("password") String userPassword
    );

    @POST("createsite")
    Call<String> saveCreateSite(@Body CreateSiteRequest createSiteRequest);

    @GET("siteshow")
    Call<List<SiteResponse>> getAllSiteDetails();

    @POST("additem")
    Call<String> saveCreateEquipment(@Body CreateEquipmentRequest createEquipmentRequest);

    @GET("site")
    Call<List<EquipmentResponse>> getAllEquipmentDetails(@Query("id") String id);

    @GET("showreport")
    Call<List<ReportResponse>> getAllReportDetails(@Query("id") String id);

  //  @POST("signup")
  //  Call<String> saveSignUpDetail(@Body SignUpRequest signUpRequest);

}
