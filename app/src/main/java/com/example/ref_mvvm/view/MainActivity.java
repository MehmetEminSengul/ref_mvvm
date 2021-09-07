package com.example.ref_mvvm.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ref_mvvm.R;
import com.example.ref_mvvm.model.login.responseModel.ResponseLogin;
import com.example.ref_mvvm.viewModel.LoginmViewModel;

public class MainActivity extends AppCompatActivity {

    private EditText userPhone;
    private EditText userPassword;
    private ProgressBar progressBar;
    private LoginmViewModel loginmViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userPhone =  findViewById(R.id.edtUserPhone);
        userPassword =  findViewById(R.id.edtPassword);
        progressBar = findViewById(R.id.progress_bar);
        loginmViewModel = ViewModelProviders.of(this).get(LoginmViewModel.class);
        loginmViewModel.init();
        observableLogin();


    }

    public void observableLogin(){
        loginmViewModel.toast.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                message(s);
            }
        });
        loginmViewModel.showProgess.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

        loginmViewModel.responseLogin.observe(this, new Observer<ResponseLogin>() {
            @Override
            public void onChanged(ResponseLogin responseLogin) {
                message(responseLogin.getMessage());
            }
        });
    }




    public void message(String message){
        Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    public void doLogin(View view) {
        loginmViewModel.setUserPhoneandPassword(userPhone.getText().toString(),userPassword.getText().toString());
        loginmViewModel.doLogin();
    }
}