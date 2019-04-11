package com.example.profileuser.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.profileuser.Model.ProfileUser;
import com.example.profileuser.R;
import com.example.profileuser.ViewHolder.RecycleViewVideosViewHolder;

import java.util.ArrayList;

public class RecycleviewVideosAdapter extends RecyclerView.Adapter<RecycleViewVideosViewHolder> {
    ArrayList<ProfileUser> dsanh = new ArrayList<>();

    public RecycleviewVideosAdapter(ArrayList<ProfileUser> dsanh) {
        this.dsanh = dsanh;
    }

    @NonNull
    @Override
    public RecycleViewVideosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_fragment_videos,viewGroup,false);
        return new RecycleViewVideosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewVideosViewHolder recycleView_photos_viewHolder, int i) {
        recycleView_photos_viewHolder.SetData(dsanh.get(i));

    }

    @Override
    public int getItemCount() {
        return dsanh.size();
    }
}
