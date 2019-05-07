package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HashTag.FragmentHashtag;
import vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HinhAnh.FragmentHinhAnh;
import vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.Video.FragmentVideo;

public class ViewPargerAdapter extends FragmentPagerAdapter {

    FragmentVideo fragment_video;
    FragmentHashtag fragment_hashtag;
    FragmentHinhAnh fragment_hinhAnh;

    public ViewPargerAdapter(FragmentManager fm) {
        super(fm);
        fragment_hashtag = new FragmentHashtag();
        fragment_hinhAnh = new FragmentHinhAnh();
        fragment_video = new FragmentVideo();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return fragment_video;

            case 1:
                return fragment_hashtag;

            case 2:
                return fragment_hinhAnh;

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
