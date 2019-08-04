package vn.edu.httpgreenacademy.vuivc.Adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentLiked;
import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentUserMain;
import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentVideos;
import vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.FragmentYeuThich;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new FragmentVideos();
            case 1:
                return new FragmentYeuThich();
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
                return "MY VIDEOS";
            case 1:
                return "MY PHOTOS";
        }
        return "";
    }
}
