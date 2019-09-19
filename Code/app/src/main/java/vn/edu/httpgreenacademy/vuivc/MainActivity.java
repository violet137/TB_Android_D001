package vn.edu.httpgreenacademy.vuivc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import vn.edu.httpgreenacademy.vuivc.UI.Login.FragmentDialogLogin;
import vn.edu.httpgreenacademy.vuivc.UI.Login.FragmentHomelogin;
import vn.edu.httpgreenacademy.vuivc.UI.Login.FragmentLogin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//         Chan Hong task 4
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentHomelogin fragmentHomelogin = new FragmentHomelogin();
        fragmentManager.beginTransaction().replace(android.R.id.content, fragmentHomelogin).addToBackStack("").commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }


}
