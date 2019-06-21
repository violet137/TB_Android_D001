package vn.edu.httpgreenacademy.vuivc.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentLiked;
import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentUserMain;
import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentVideos;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new FragmentLiked();
            case 1:
                return new FragmentVideos();
            case 2:
                return new FragmentUserMain();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "PHOTOS";
            case 1:
                return "VIDEOS";
            case 2:
                return "PROFILE";
        }
        return "";
    }
}
