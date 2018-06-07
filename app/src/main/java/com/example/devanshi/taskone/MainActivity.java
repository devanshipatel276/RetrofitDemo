package com.example.devanshi.taskone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fragement.SpinnerFragement;

public class MainActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container1, new SpinnerFragement());
        ft.commit();

    }


}
