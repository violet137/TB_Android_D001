package com.example.profileuser.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.profileuser.Model.ProfileUser;


import java.util.ArrayList;

public class GridViewLikedAdapter extends BaseAdapter {
    ArrayList<ProfileUser> dsanhlike = new ArrayList<>();
    @Override
    public int getCount() {
        return dsanhlike.size();
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
        if(convertView == null)
        {

        }
        return null;
    }
}
