package vn.edu.httpgreenacademy.vuivc;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.edu.httpgreenacademy.vuivc.Network.FragmentLession;
import vn.edu.httpgreenacademy.vuivc.UI.Login.Fragment_Home;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FragmentLession fragmentLession = new FragmentLession();

        Fragment_Home fragment_home = new Fragment_Home();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(android.R.id.content, fragmentLession).commit();

    }
}
