package vn.edu.httpgreenacademy.vuivc;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

     int NUM_ITEMS = 3;
    VideoListFragment videoListFragment;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int i) {
        videoListFragment = new VideoListFragment();
        videoListFragment.type_video = i;
        return videoListFragment;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Mới";
            case 1:
                return "Xu hướng";
            case 2:
                return "Theo dõi";
        }
        return "Mới";
    }
}
