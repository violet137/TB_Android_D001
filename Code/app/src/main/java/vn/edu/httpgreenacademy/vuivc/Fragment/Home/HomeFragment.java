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
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import vn.edu.httpgreenacademy.vuivc.Fragment.Channel.FragmentDiscoveryMonitor;
import vn.edu.httpgreenacademy.vuivc.Fragment.Channel.FragmentNotification;
import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentUserMain;
import vn.edu.httpgreenacademy.vuivc.R;
import static com.facebook.AccessTokenManager.SHARED_PREFERENCES_NAME;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewHome = inflater.inflate(R.layout.fragment_home,container,false);
        final ViewPager viewPagerHome = viewHome.findViewById(R.id.viewPagerHome);
        TabLayout tabLayoutHome = viewHome.findViewById(R.id.tabLayoutHome);
        BottomNavigationView viewHomeBottomNavigation = viewHome.findViewById(R.id.viewHomeBottomNavigation);

        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getFragmentManager());
        viewPagerHome.setAdapter(homePagerAdapter);
        tabLayoutHome.setupWithViewPager(viewPagerHome);

        viewHomeBottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.navigation_propose:
                    {
                        //LoadFragment(new HomeFragment());
                        break;
                    }
                    case R.id.navigation_discovery:
                    {
                        //LoadFragment(new FragmentDiscoveryMonitor());
                        break;
                    }
                    case R.id.navigation_add:
                    {
                        break;
                    }
                    case R.id.navigation_notification:
                    {
                        //LoadFragment(new FragmentNotification());
                        break;
                    }
                    case R.id.navigation_profile:
                    {
                        //LoadFragment(new FragmentUserMain());
                        break;
                    }
                }
                return false;
            }
        });

        return viewHome;
    }

    private void LoadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}


