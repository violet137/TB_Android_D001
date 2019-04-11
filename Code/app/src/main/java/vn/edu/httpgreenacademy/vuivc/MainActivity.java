package vn.edu.httpgreenacademy.vuivc;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        VerticalVideoFragment videoPagerFragment = new VerticalVideoFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(android.R.id.content,videoPagerFragment).commit();

    }



}
