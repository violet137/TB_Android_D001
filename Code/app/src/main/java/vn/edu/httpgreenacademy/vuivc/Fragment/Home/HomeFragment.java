package vn.edu.httpgreenacademy.vuivc.Fragment.Home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.httpgreenacademy.vuivc.R;

public class HomeFragment extends Fragment {

    ViewPager viewPagerHome;
    TabLayout tabLayoutHome;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewHome = inflater.inflate(R.layout.fragment_home,container,false);
        viewPagerHome = viewHome.findViewById(R.id.viewPagerHome);
        tabLayoutHome = viewHome.findViewById(R.id.tabLayoutHome);

        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getFragmentManager());
        viewPagerHome.setAdapter(homePagerAdapter);
        tabLayoutHome.setupWithViewPager(viewPagerHome);
        return viewHome;
    }
}


