package com.example.restapi;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.restapi.Network.BaiHoc;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView txtTen,img;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img_item);
        txtTen = itemView.findViewById(R.id.txt_item);
    }
    public void SetData(BaiHoc baiHoc)
    {
        img.setText(baiHoc.getImageUrl());
        txtTen.setText(baiHoc.getName()+"");
    }
}
