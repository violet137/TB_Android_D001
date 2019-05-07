package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.Video;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.Video.VideoModel;
import vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.Video.VideoViewHolder;

public class VideoAdapter extends RecyclerView.Adapter<VideoViewHolder> {
    ArrayList<VideoModel> videoModelArrayList = new ArrayList<>();
    Activity activity;

    public VideoAdapter(ArrayList<VideoModel> videoModelArrayList, Activity activity) {
        this.videoModelArrayList = videoModelArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_video, viewGroup, false);

        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, int i) {
        final VideoModel videoModel = videoModelArrayList.get(i);
        videoViewHolder.setdatavideo(videoModel);
    }

    @Override
    public int getItemCount() {
        return videoModelArrayList.size();
    }
}
