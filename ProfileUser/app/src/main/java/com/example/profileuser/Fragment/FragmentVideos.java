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

import com.example.profileuser.Adapter.RecycleViewLikedAdapter;
import com.example.profileuser.Model.ProfileUser;
import com.example.profileuser.R;

import java.util.ArrayList;

public class FragmentVideos extends Fragment {
    RecyclerView recyclerView;
    ArrayList<ProfileUser> dsAnh = new ArrayList<>();
    RecycleViewLikedAdapter recycleView_liked_adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_videos, container, false);
        recyclerView = view.findViewById(R.id.recycle_photo);
        recycleView_liked_adapter = new RecycleViewLikedAdapter(dsAnh);
        recyclerView.setAdapter(recycleView_liked_adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        return view;
    }
}
