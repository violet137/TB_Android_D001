package vn.edu.httpgreenacademy.vuivc;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

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
        Log.d("video link",listVideo.get(position).getVideoUrl());
        return FragmentOne.newInstance(position,listVideo.get(position).getVideoName(),listVideo.get(position).getVideoUrl());
    }

    @Override
    public int getCount() {
        return listVideo.size();
    }

}
