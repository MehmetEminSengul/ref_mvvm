package com.example.ref_mvvm.api;

import com.example.ref_mvvm.model.login.responseModel.ResponseLogin;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {
    @POST("/api//login")
    Call<ResponseLogin> login(@Header("ReqType") String reqType, @Body RequestBody type);

}
