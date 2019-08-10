package vn.edu.httpgreenacademy.vuivc.Fragment.Home;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.Fragment.AboutApp.FragmentAboutApp;
import vn.edu.httpgreenacademy.vuivc.Fragment.DanhSach.FragmentDanhSachFollowing;
import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentLiked;
import vn.edu.httpgreenacademy.vuivc.Fragment.ProfileUser.FragmentUserMain;
import vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer.VerticalVideoFragment;
import vn.edu.httpgreenacademy.vuivc.FragmentGif;
import vn.edu.httpgreenacademy.vuivc.R;

public class HomePagerAdapter extends FragmentStatePagerAdapter {

    public int TOTAL_FRAGMENT_ITEMS = 2;
    private ArrayList<Fragment> mFragments;

    public HomePagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return FragmentGif.newInstance(0);
            case 1: return VerticalVideoFragment.newInstance(1);
            default: return FragmentGif.newInstance(0);
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
            default:return "PHOTOS";
        }
    }


}
