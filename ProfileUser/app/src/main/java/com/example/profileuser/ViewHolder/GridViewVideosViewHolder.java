package com.example.profileuser.ViewHolder;

import android.view.View;
import android.widget.ImageView;

import com.example.profileuser.Model.ProfileUser;
import com.example.profileuser.R;

public class GridViewVideosViewHolder {
    ImageView img_photos;
    public GridViewVideosViewHolder(View itemView) {
        img_photos = itemView.findViewById(R.id.img_photos);
    }
    public void SetData(ProfileUser profile_user)
    {
        img_photos.setImageResource(profile_user.getPhoto());
    }
}
