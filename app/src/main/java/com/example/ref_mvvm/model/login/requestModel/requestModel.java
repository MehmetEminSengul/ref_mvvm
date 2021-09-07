package com.example.ref_mvvm.model.login.requestModel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfo {
    @SerializedName("UserPhone")
    @Expose
    private String userPhone;
    @SerializedName("Password")
    @Expose
    private String password;

    public String getPassword() {
        return password;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}