package com.example.devanshi.taskone;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.devanshi.taskone.databinding.ActivityUserInfoBinding;

import model.UserModel;

public class UserInfoActivity extends AppCompatActivity
{

ActivityUserInfoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_user_info);
        UserModel userModel=new UserModel("Devu","ABC");

        binding.setUsermodel(userModel);

    }
}
