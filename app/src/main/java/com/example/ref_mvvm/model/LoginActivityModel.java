package com.example.ref_mvvm.model;


import com.example.ref_mvvm.api.ApiService;
import com.example.ref_mvvm.api.ApiUtils;
import com.example.ref_mvvm.api.RequestResultListener;
import com.example.ref_mvvm.model.login.requestModel.UserInfo;
import com.example.ref_mvvm.model.login.responseModel.ResponseLogin;
import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class LoginActivityModel {

    private ApiService apiService;
    Gson gson = new Gson();

    UserInfo userInfo;



    public void initApiService() {
        apiService = ApiUtils.getAPIService();
    }


    public void setLogin(String userPhone,String password) {
        userInfo = new UserInfo();
        userInfo.setUserPhone(userPhone);
        userInfo.setPassword(password);
    }


    public void doLogin(String userPhone, String password, final RequestResultListener requestResultListener) {

        initApiService();

        setLogin(userPhone,password);

        apiService.login("Android", RequestBody.create(MediaType.parse("application/json"), gson.toJson(userInfo))).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if(response.isSuccessful())
                    requestResultListener.onSuccess(response);
                else
                    requestResultListener.onFail();
            }
            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                requestResultListener.onFail();
            }
        });


    }

}