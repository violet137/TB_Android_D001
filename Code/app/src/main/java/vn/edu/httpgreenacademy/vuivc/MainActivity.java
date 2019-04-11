package vn.edu.httpgreenacademy.vuivc;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.edu.httpgreenacademy.vuivc.Fragment.FragmentUserMain;
import vn.edu.httpgreenacademy.vuivc.UI.Login.FragmentHome;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentHome fragment_home = new FragmentHome();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentUserMain fragmentUserMain = new FragmentUserMain();
        fragmentManager.beginTransaction().replace(android.R.id.content, fragmentUserMain).commit();



    }
}
