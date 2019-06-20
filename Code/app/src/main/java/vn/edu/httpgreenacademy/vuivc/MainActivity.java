package vn.edu.httpgreenacademy.vuivc;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import vn.edu.httpgreenacademy.vuivc.Fragment.Comment.Comment_Dialog_Fragmment;
import vn.edu.httpgreenacademy.vuivc.Fragment.Home.HomeFragment;
import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentUserMain;
import vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer.VerticalVideoFragment;
import vn.edu.httpgreenacademy.vuivc.UI.Login.FragmentHome;
import vn.edu.httpgreenacademy.vuivc.UI.Login.FragmentLogin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentLogin fragmentLogin = new FragmentLogin();
        fragmentManager.beginTransaction().replace(android.R.id.content, fragmentLogin).commit();
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
