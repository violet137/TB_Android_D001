package com.example.profileuser.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.profileuser.Model.Profile_User;
import com.example.profileuser.R;
import com.example.profileuser.ViewHolder.RecycleView_Videos_ViewHolder;

import java.util.ArrayList;

public class Recycleview_Videos_Adapter extends RecyclerView.Adapter<RecycleView_Videos_ViewHolder> {
    ArrayList<Profile_User> dsanh = new ArrayList<>();

    public Recycleview_Videos_Adapter(ArrayList<Profile_User> dsanh) {
        this.dsanh = dsanh;
    }

    @NonNull
    @Override
    public RecycleView_Videos_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_fragment_videos,viewGroup,false);
        return new RecycleView_Videos_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleView_Videos_ViewHolder recycleView_photos_viewHolder, int i) {
        recycleView_photos_viewHolder.SetData(dsanh.get(i));

    }

    @Override
    public int getItemCount() {
        return dsanh.size();
    }
}
