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
import vn.edu.httpgreenacademy.vuivc.R;

public class HomePagerAdapter extends FragmentPagerAdapter {

    public int TOTAL_FRAGMENT_ITEMS = 4;

    public HomePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0 :return new FragmentAboutApp();
            case 1: return new FragmentLiked();
            case 2: return new VerticalVideoFragment();
            case 3: return new FragmentUserMain();
        }
        return null;
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
            case 0: return "Mới nhất";
            case 1: return "Xu hướng";
            case 2: return "Video";
            case 3: return "Ảnh";
        }
        return "";
    }
}
