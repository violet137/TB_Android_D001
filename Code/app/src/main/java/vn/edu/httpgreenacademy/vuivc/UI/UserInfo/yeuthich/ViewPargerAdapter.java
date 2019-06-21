package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HashTag.FragmentHashtag;
import vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HinhAnh.FragmentHinhAnh;
import vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.Video.FragmentVideo;

public class ViewPargerAdapter extends FragmentPagerAdapter {

    public ViewPargerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentVideo();
            case 1:
                return new FragmentHashtag();
            case 2:
                return new FragmentHinhAnh();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Video";
            case 1:
                return "Hashtag";
            case 2:
                return "Hình Ảnh";
        }
        return "";

    }

    @Override
    public int getCount() {
        return 3;
    }
}
