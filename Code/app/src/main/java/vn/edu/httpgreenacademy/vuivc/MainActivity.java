package vn.edu.httpgreenacademy.vuivc;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentUserMain;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentUserMain fragmentUserMain = new FragmentUserMain();
        fragmentManager.beginTransaction().replace(android.R.id.content, fragmentUserMain).commit();
//        VerticalVideoFragment videoPagerFragment = new VerticalVideoFragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction().replace(android.R.id.content,videoPagerFragment).commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for(Fragment fragment:getSupportFragmentManager().getFragments())
        {
            fragment.onActivityResult(requestCode,resultCode,data);
        }
    }



}
