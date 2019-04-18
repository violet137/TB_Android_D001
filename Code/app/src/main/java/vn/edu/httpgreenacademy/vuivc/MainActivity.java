package vn.edu.httpgreenacademy.vuivc;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import vn.edu.httpgreenacademy.vuivc.Draw.FragmentPickAVUICC;
import vn.edu.httpgreenacademy.vuivc.Network.FragmentLession;
import vn.edu.httpgreenacademy.vuivc.UI.Login.FragmentHome;
import vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.FragmentYeuThich;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FragmentLession fragmentLession = new FragmentLession();

        FragmentHome fragment_home = new FragmentHome();

        FragmentYeuThich fragmentyeuThich = new FragmentYeuThich();

        FragmentPickAVUICC fragmentPickAVUICC = new FragmentPickAVUICC();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(android.R.id.content, fragmentyeuThich).commit();

    }

}
