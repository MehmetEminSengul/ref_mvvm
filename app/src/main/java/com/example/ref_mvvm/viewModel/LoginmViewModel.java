package com.example.ref_mvvm.viewModel;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ref_mvvm.api.RequestResultListener;
import com.example.ref_mvvm.model.LoginActivityModel;
import com.example.ref_mvvm.model.login.responseModel.ResponseLogin;

import retrofit2.Response;

/**
 * Created by enespecenek on 2019-08-30.
 */
public class LoginmViewModel extends ViewModel {
    public MutableLiveData<String> userPhone =  new MutableLiveData<String>();
    public MutableLiveData<String> userPassword =  new MutableLiveData<>();
    public MutableLiveData<String> toast = new MutableLiveData<>();
    public MutableLiveData<Boolean> showProgess =  new MutableLiveData<>();
    public MutableLiveData<ResponseLogin> responseLogin = new MutableLiveData<>();
    private LoginActivityModel loginActivityModel;

    String strofUserPhone;
    String strofUserPassword;

    public void init(){
        loginActivityModel =  new LoginActivityModel();
    }

    public void setUserPhoneandPassword(String userMobilePhone,String userPasswor){
        userPhone.setValue(String.valueOf(userMobilePhone));
        userPassword.setValue(userPasswor);
    }


    private boolean isUserLoginInfoValid() {
        if (userPhone.getValue().equals("")  && userPhone.getValue().trim().length() != 11) {
            return false;
        }
        if (userPassword.getValue().equals("") && userPassword.toString().trim().length() < 6) {
            return false;
        }
        strofUserPhone = userPhone.getValue().trim();
        strofUserPassword = userPassword.getValue().trim();
        return true;
    }



    public void doLogin() {

        if(isUserLoginInfoValid()){
            showProgess.postValue(true);
            loginActivityModel.doLogin(strofUserPhone,strofUserPassword, new RequestResultListener() {
                @Override
                public void onSuccess(Response response) {
                    showProgess.postValue(true);
                    responseLogin.postValue((ResponseLogin) response.body());
                }

                @Override
                public void onUnSuccess(Response response) {
                    showProgess.postValue(false);
                }

                @Override
                public void onFail() {
                    showProgess.postValue(false);
                    toast.postValue("Login işleminde hata olustu!");

                }
            });
        }else{
            toast.postValue("Tüm alanları istenen şekilde doldurunuz.");
        }


    }


}