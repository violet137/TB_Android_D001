package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HashTag;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.R;

public class HashTagAdapterVideo extends RecyclerView.Adapter<HashTagViewHoderVideo> {
    ArrayList<HashtagModel> hashtagModelArrayList = new ArrayList<>();
    Activity activity;

    public HashTagAdapterVideo(ArrayList<HashtagModel> hashtagModelArrayList, Activity activity) {
        this.hashtagModelArrayList = hashtagModelArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public HashTagViewHoderVideo onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemhashtagvideo, viewGroup, false);

        return new HashTagViewHoderVideo(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HashTagViewHoderVideo hashTagViewHoderVideo, int i) {
        HashtagModel hashtagModel = hashtagModelArrayList.get(i);
        hashTagViewHoderVideo.setdataVideo(hashtagModel);
    }

    @Override
    public int getItemCount() {
        return hashtagModelArrayList.size();
    }
}
