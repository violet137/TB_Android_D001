package vn.edu.httpgreenacademy.vuivc;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Window;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        FragmentGif fragmentGif=new FragmentGif();
        FragmentManager fragmentManager=getFragmentManager();
        fragmentManager.beginTransaction().replace(android.R.id.content, fragmentGif).commit();
    }
}
