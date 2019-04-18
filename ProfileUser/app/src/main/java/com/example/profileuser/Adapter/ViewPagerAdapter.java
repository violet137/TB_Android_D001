package com.example.profileuser.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.profileuser.Fragment.FragmentLiked;
import com.example.profileuser.Fragment.FragmentVideos;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    FragmentVideos fragmentvideos;
    FragmentLiked fragmentliked;
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentvideos = new FragmentVideos();
        fragmentliked = new FragmentLiked();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return fragmentvideos;
            case 1:
                return fragmentliked;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "VIDEOS";
            case 1:
                return "LIKED";
        }
        return "";
    }
}
