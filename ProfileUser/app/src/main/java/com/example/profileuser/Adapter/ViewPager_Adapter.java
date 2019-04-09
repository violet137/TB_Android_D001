package com.example.profileuser.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.profileuser.Fragment.Fragment_Liked;
import com.example.profileuser.Fragment.Fragment_Videos;

public class ViewPager_Adapter extends FragmentPagerAdapter {
    Fragment_Videos fragment_videos;
    Fragment_Liked fragment_liked;
    public ViewPager_Adapter(FragmentManager fm) {
        super(fm);
        fragment_videos = new Fragment_Videos();
        fragment_liked = new Fragment_Liked();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return fragment_videos;
            case 1:
                return fragment_liked;
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
