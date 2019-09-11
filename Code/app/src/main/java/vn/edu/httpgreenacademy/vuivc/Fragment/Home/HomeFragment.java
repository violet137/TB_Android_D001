package vn.edu.httpgreenacademy.vuivc.Fragment.Home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import vn.edu.httpgreenacademy.vuivc.Activity.ProfileUser_Activity;
import vn.edu.httpgreenacademy.vuivc.R;

import static com.facebook.AccessTokenManager.SHARED_PREFERENCES_NAME;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewHome = inflater.inflate(R.layout.fragment_home,container,false);
        ViewPager viewPagerHome = viewHome.findViewById(R.id.viewPagerHome);
        TabLayout tabLayoutHome = viewHome.findViewById(R.id.tabLayoutHome);
        BottomNavigationViewEx viewHomeBottomNavigation = viewHome.findViewById(R.id.viewHomeBottomNavigation);

        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getFragmentManager());
        viewPagerHome.setAdapter(homePagerAdapter);
        tabLayoutHome.setupWithViewPager(viewPagerHome);
        viewHomeBottomNavigation.enableItemShiftingMode(false);
        viewHomeBottomNavigation.enableAnimation(false);
        viewHomeBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.navigation_profile) {
                    Intent intent = new Intent(getActivity(), ProfileUser_Activity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        return viewHome;
    }
}


