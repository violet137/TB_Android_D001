package vn.edu.httpgreenacademy.vuivc.Fragment.Home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

<<<<<<< Updated upstream
import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer.VerticalVideoFragment;
import vn.edu.httpgreenacademy.vuivc.FragmentGif;
=======
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import vn.edu.httpgreenacademy.vuivc.Activity.ProfileUser_Activity;
>>>>>>> Stashed changes
import vn.edu.httpgreenacademy.vuivc.R;

import static com.facebook.AccessTokenManager.SHARED_PREFERENCES_NAME;

public class HomeFragment extends Fragment {

    ViewPager viewPagerHome;
    TabLayout tabLayoutHome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewHome = inflater.inflate(R.layout.fragment_home,container,false);
<<<<<<< Updated upstream
        viewPagerHome = viewHome.findViewById(R.id.viewPagerHome);
        tabLayoutHome = viewHome.findViewById(R.id.tabLayoutHome);

=======
        ViewPager viewPagerHome = viewHome.findViewById(R.id.viewPagerHome);
        TabLayout tabLayoutHome = viewHome.findViewById(R.id.tabLayoutHome);
        BottomNavigationViewEx viewHomeBottomNavigation = viewHome.findViewById(R.id.viewHomeBottomNavigation);
>>>>>>> Stashed changes

        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getActivity().getSupportFragmentManager());
        viewPagerHome.setAdapter(homePagerAdapter);
        viewPagerHome.setOffscreenPageLimit(2);
        tabLayoutHome.setupWithViewPager(viewPagerHome);
<<<<<<< Updated upstream

=======
        viewHomeBottomNavigation.enableItemShiftingMode(false);
        viewHomeBottomNavigation.enableAnimation(false);
        viewHomeBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.navigation_profile) {
<<<<<<< HEAD
                    Intent intent = new Intent(getActivity(), ProfileUser_Activity.class);
                    startActivity(intent);
=======
                    FragmentUserMain fragmentUserMain = new FragmentUserMain();
                    getFragmentManager().beginTransaction()
                            .replace(android.R.id.content,fragmentUserMain)
                            .addToBackStack("Profile user").commit();

>>>>>>> beefe2283a34784b2a1f08cdbc25c03d40cfed40
                    return true;
                }
                return false;
            }
        });
>>>>>>> Stashed changes

        return viewHome;
    }
}


