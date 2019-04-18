package vn.edu.httpgreenacademy.vuivc.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentLiked;
import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentVideos;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    FragmentVideos fragment_videos;
    FragmentLiked fragment_liked;
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragment_videos = new FragmentVideos();
        fragment_liked = new FragmentLiked();
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
