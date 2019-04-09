package com.example.profileuser.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.profileuser.Model.Profile_User;
import com.example.profileuser.R;
import com.example.profileuser.ViewHolder.RecycleView_Liked_ViewHolder;


import java.util.ArrayList;

public class RecycleView_Liked_Adapter extends RecyclerView.Adapter<RecycleView_Liked_ViewHolder> {
    ArrayList<Profile_User> dsanhlike = new ArrayList<>();

    public RecycleView_Liked_Adapter(ArrayList<Profile_User> dsanh) {
        this.dsanhlike = dsanh;
    }

    @NonNull
    @Override
    public RecycleView_Liked_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_fragment_liked,viewGroup,false);
        return new RecycleView_Liked_ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleView_Liked_ViewHolder recycleView_liked_viewHolder, int i) {
        recycleView_liked_viewHolder.SetData(dsanhlike.get(i));

    }

    @Override
    public int getItemCount() {
        return dsanhlike.size();
    }
}
