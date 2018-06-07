package com.example.devanshi.taskone;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.devanshi.taskone.databinding.ActivityLanguageBinding;

import java.util.List;

import adapter.LanguageAdapter;
import model.CountryModel;

public class LanguageActivity extends AppCompatActivity
{
    List<CountryModel.LanguagesBean> list;
    ActivityLanguageBinding binding;
    LanguageAdapter languageAdapter;
    private static final String TAG = "LanguageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_language);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        list= (List<CountryModel.LanguagesBean>)bundle.getSerializable("ARRAYLIST");

//        Log.d(TAG, "onCreate: "+list.get(0).getName());


        languageAdapter = new LanguageAdapter(this, (List<CountryModel.LanguagesBean>) list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setAdapter(languageAdapter);
        binding.recyclerview.setLayoutManager(layoutManager);


    }
}
