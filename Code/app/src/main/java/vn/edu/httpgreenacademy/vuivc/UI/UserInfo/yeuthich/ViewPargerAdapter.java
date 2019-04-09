package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPargerAdapter extends FragmentPagerAdapter {

    Fragment_Video fragment_video;
    Fragment_Hashtag fragment_hashtag;
    Fragment_HinhAnh fragment_hinhAnh;

    public ViewPargerAdapter(FragmentManager fm) {
        super(fm);
        fragment_hashtag = new Fragment_Hashtag();
        fragment_hinhAnh = new Fragment_HinhAnh();
        fragment_video = new Fragment_Video();
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
