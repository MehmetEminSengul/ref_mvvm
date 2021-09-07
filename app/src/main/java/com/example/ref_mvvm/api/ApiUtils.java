package com.example.ref_mvvm.api;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://172.12.230.21:83/";

    public static ApiService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}
