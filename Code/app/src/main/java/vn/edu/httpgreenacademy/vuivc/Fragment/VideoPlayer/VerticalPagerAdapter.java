package vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer.FragmentItemVideo;
import vn.edu.httpgreenacademy.vuivc.Model.VideoModel;

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
