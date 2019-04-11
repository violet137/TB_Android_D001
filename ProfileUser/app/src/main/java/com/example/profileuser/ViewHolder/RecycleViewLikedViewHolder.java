package com.example.profileuser.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.profileuser.Model.ProfileUser;
import com.example.profileuser.R;

public class RecycleViewLikedViewHolder extends RecyclerView.ViewHolder {
    ImageView img_liked;
    public RecycleViewLikedViewHolder(@NonNull View itemView) {
        super(itemView);
        img_liked = itemView.findViewById(R.id.img_liked);
    }
    public void SetData(ProfileUser profile_user)
    {
        img_liked.setImageResource(profile_user.getPhoto());
    }
}
