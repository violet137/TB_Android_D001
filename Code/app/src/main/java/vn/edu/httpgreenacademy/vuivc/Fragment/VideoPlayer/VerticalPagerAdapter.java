package vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.edu.httpgreenacademy.vuivc.Api.ApiUtils;
import vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer.FragmentItemVideo;
import vn.edu.httpgreenacademy.vuivc.Model.VideoModel;
import vn.edu.httpgreenacademy.vuivc.ModelUser.ProfileUser;

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
