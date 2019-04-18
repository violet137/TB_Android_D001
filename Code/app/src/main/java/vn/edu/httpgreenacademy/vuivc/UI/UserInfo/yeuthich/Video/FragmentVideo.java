package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.Video;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;

public class FragmentVideo extends Fragment {
    RecyclerView listYeuThichVideo;
    ArrayList<VideoModel> datavideo = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        listYeuThichVideo = view.findViewById(R.id.List_Yeuthich_Video);

        SnapHelper snapHelper = new GravitySnapHelper(Gravity.START);
        snapHelper.attachToRecyclerView(listYeuThichVideo);

        VideoAdapter videoAdapter = new VideoAdapter(datavideo,getActivity());
        listYeuThichVideo.setAdapter(videoAdapter);
        listYeuThichVideo.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.HORIZONTAL,false));
        TypedArray video = getResources().obtainTypedArray(R.array.hinhanh);
        for(int i=0;i< video.length();i++)
        {
            VideoModel videoModel = new VideoModel(video.getResourceId(i,-1));
            datavideo.add(videoModel);
        }
        return view;
    }
}
