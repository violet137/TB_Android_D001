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

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer.VerticalVideoFragment;
import vn.edu.httpgreenacademy.vuivc.FragmentGif;
import vn.edu.httpgreenacademy.vuivc.R;

import static com.facebook.AccessTokenManager.SHARED_PREFERENCES_NAME;

public class HomeFragment extends Fragment {

    ViewPager viewPagerHome;
    TabLayout tabLayoutHome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewHome = inflater.inflate(R.layout.fragment_home,container,false);
        viewPagerHome = viewHome.findViewById(R.id.viewPagerHome);
        tabLayoutHome = viewHome.findViewById(R.id.tabLayoutHome);


        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getActivity().getSupportFragmentManager());
        viewPagerHome.setAdapter(homePagerAdapter);
        viewPagerHome.setOffscreenPageLimit(2);
        tabLayoutHome.setupWithViewPager(viewPagerHome);


        return viewHome;
    }
}


