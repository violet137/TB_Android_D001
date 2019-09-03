package vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.ArrayList;
import vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer.FragmentItemVideo;
import vn.edu.httpgreenacademy.vuivc.Model.VideoModel;

public class VerticalPagerAdapter extends FragmentPagerAdapter {

    ArrayList<VideoModel> listVideo = new ArrayList<VideoModel>();
    int TOTAL_PAGES = 0;

    public VerticalPagerAdapter(FragmentManager fm, ArrayList<VideoModel> videoModels)
    {
        super(fm);
        this.listVideo = videoModels;
        this.TOTAL_PAGES = videoModels.size();
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentItemVideo.newInstance(listVideo.get(position),position + 1);
    }

    @Override
    public int getCount() {
        return TOTAL_PAGES;
    }

}
