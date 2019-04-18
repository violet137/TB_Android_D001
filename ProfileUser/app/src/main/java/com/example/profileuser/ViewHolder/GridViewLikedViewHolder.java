package com.example.profileuser.ViewHolder;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;

import com.example.profileuser.Model.ProfileUser;
import com.example.profileuser.R;

public class GridViewLikedViewHolder {
    ImageView imgliked;
    public GridViewLikedViewHolder(@NonNull View itemView) {
        imgliked = itemView.findViewById(R.id.img_liked);
    }
    public void SetData(ProfileUser profile_user)
    {
        imgliked.setImageResource(profile_user.getPhoto());
    }
}
