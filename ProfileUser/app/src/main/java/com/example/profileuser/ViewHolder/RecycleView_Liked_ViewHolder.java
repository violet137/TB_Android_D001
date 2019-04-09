package com.example.profileuser.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.profileuser.Model.Profile_User;
import com.example.profileuser.R;

public class RecycleView_Liked_ViewHolder extends RecyclerView.ViewHolder {
    ImageView img_liked;
    public RecycleView_Liked_ViewHolder(@NonNull View itemView) {
        super(itemView);
        img_liked = itemView.findViewById(R.id.img_liked);
    }
    public void SetData(Profile_User profile_user)
    {
        img_liked.setImageResource(profile_user.getPhoto());
    }
}
