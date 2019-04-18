package com.example.restapi;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentLogin fragmentLogin = new FragmentLogin();
        getSupportFragmentManager().beginTransaction().replace(android.R.id.content,fragmentLogin).commit();

    }
}
