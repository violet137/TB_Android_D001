package com.example.profileuser.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.profileuser.Adapter.RecycleView_Liked_Adapter;
import com.example.profileuser.Model.Profile_User;
import com.example.profileuser.R;

import java.util.ArrayList;

public class Fragment_Videos extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Profile_User> dsAnh = new ArrayList<>();
    RecycleView_Liked_Adapter recycleView_liked_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_videos, container, false);
        recyclerView = view.findViewById(R.id.recycle_photo);
        recycleView_liked_adapter = new RecycleView_Liked_Adapter(dsAnh);
        recyclerView.setAdapter(recycleView_liked_adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        return view;
    }
}