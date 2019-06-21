package vn.edu.httpgreenacademy.vuivc;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vn.edu.httpgreenacademy.vuivc.Draw.FragmentDraw;
import vn.edu.httpgreenacademy.vuivc.Draw.FragmentPickAVUICC;
import vn.edu.httpgreenacademy.vuivc.Fragment.Home.HomeFragment;
import vn.edu.httpgreenacademy.vuivc.UI.Login.FragmentDialogLogin;
import vn.edu.httpgreenacademy.vuivc.UI.Login.FragmentHomelogin;
import vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.FragmentYeuThich;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getSupportFragmentManager();
        HomeFragment fragmentUserMain = new HomeFragment();
        FragmentDraw fragmentDraw = new FragmentDraw();
        FragmentHomelogin fragmentHomelogin = new FragmentHomelogin();
        FragmentYeuThich fragmentYeuThich = new FragmentYeuThich();
        fragmentManager.beginTransaction().replace(android.R.id.content,fragmentYeuThich).commit();
}

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        for(Fragment fragment:getSupportFragmentManager().getFragments())
//        {
//            fragment.onActivityResult(requestCode,resultCode,data);
//        }
//    }



}
