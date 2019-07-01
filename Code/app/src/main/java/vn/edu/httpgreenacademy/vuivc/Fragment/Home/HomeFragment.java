package vn.edu.httpgreenacademy.vuivc.Fragment.Home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import vn.edu.httpgreenacademy.vuivc.R;

import static com.facebook.AccessTokenManager.SHARED_PREFERENCES_NAME;

public class HomeFragment extends Fragment {

    ViewPager viewPagerHome;
    TabLayout tabLayoutHome;
    TextView tvUserHome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewHome = inflater.inflate(R.layout.fragment_home,container,false);
        viewPagerHome = viewHome.findViewById(R.id.viewPagerHome);
        tabLayoutHome = viewHome.findViewById(R.id.tabLayoutHome);
        tvUserHome = viewHome.findViewById(R.id.tvUserHome);

        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getFragmentManager());
        viewPagerHome.setAdapter(homePagerAdapter);
        tabLayoutHome.setupWithViewPager(viewPagerHome);

        // Get user login
        SharedPreferences sharedPref = getActivity().getSharedPreferences(getString(R.string.fb_sharePre_Name),Context.MODE_PRIVATE);
        if(sharedPref != null)
        {
            String getFbUserName = sharedPref.getString("fb_sharePre_login_name", "");
            tvUserHome.setText(getFbUserName);
        }
        return viewHome;
    }
}


