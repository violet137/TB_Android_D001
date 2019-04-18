package vn.edu.httpgreenacademy.vuivc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VerticalPagerAdapter extends FragmentPagerAdapter {

    ArrayList<VideoModel> listVideo = new ArrayList<VideoModel>();

    public VerticalPagerAdapter(FragmentManager fm, ArrayList<VideoModel> videoModels)
    {
        super(fm);
        this.listVideo = videoModels;
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentItemVideo.newInstance(position,listVideo.get(position));
    }

    @Override
    public int getCount() {
        return listVideo.size();
    }

}
