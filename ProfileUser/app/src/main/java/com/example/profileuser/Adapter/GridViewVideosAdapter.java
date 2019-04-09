package com.example.profileuser.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.profileuser.Fragment.FragmentVideos;
import com.example.profileuser.Model.ProfileUser;
import com.example.profileuser.ViewHolder.GridViewVideosViewHolder;

import java.util.ArrayList;

public class GridViewVideosAdapter extends BaseAdapter {
    ArrayList<ProfileUser> dsanh = new ArrayList<>();

    public GridViewVideosAdapter(ArrayList<ProfileUser> dsanh) {
        this.dsanh = dsanh;
    }


    @Override
    public int getCount() {
        return dsanh.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView img;
        FragmentVideos fragment_videos = new FragmentVideos();
        convertView =  fragment_videos.onCreateView(LayoutInflater.from(parent.getContext()),parent,new Bundle());
        GridViewVideosViewHolder gridView_videos_viewHolder = new GridViewVideosViewHolder(convertView);
        return convertView;
    }
}
