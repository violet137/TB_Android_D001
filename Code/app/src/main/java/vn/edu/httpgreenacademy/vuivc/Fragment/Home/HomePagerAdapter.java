package vn.edu.httpgreenacademy.vuivc.Fragment.Home;

import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import vn.edu.httpgreenacademy.vuivc.Fragment.AboutApp.FragmentAboutApp;
import vn.edu.httpgreenacademy.vuivc.Fragment.DanhSach.FragmentDanhSachFollowing;
import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentLiked;
import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentUserMain;
import vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer.VerticalVideoFragment;
import vn.edu.httpgreenacademy.vuivc.FragmentGif;
import vn.edu.httpgreenacademy.vuivc.R;

public class HomePagerAdapter extends FragmentPagerAdapter {

    public int TOTAL_FRAGMENT_ITEMS = 3;

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0: return FragmentGif.newInstance(0,"PHOTOS");
            case 1: return VerticalVideoFragment.newInstance(1,"VIDEOS");
            case 2: return FragmentUserMain.newInstance(2,"PROFILE");
            default: return FragmentUserMain.newInstance(0,"PHOTOS");
        }

    }

    @Override
    public int getCount() {
        return TOTAL_FRAGMENT_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0: return "PHOTOS";
            case 1: return "VIDEOS";
            case 2: return "PROFILE";
            default:return "PHOTOS";
        }
    }
}
