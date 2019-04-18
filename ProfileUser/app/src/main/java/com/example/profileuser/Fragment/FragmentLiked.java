package com.example.profileuser.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.profileuser.Model.ProfileUser;
import com.example.profileuser.R;

import java.util.ArrayList;

public class FragmentLiked extends Fragment {
    ArrayList<ProfileUser> dsAnh = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_liked, container, false);
        return view;
    }
}
