package com.example.profileuser;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.profileuser.Fragment.FragmentUserMain;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       getSupportFragmentManager().beginTransaction().replace(android.R.id.content,fragmentUserMain).commit();

    }

}
