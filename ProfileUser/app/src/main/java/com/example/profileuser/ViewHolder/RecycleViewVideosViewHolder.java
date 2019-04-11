package com.example.profileuser.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.profileuser.ModelUser.ProfileUser;
import com.example.profileuser.R;

public class RecycleViewVideosViewHolder extends RecyclerView.ViewHolder {
    ImageView img_photos;
    public RecycleViewVideosViewHolder(@NonNull View itemView) {
        super(itemView);
        img_photos = itemView.findViewById(R.id.img_photos);
    }
    public void SetData(ProfileUser profile_user)
    {
        img_photos.setImageResource(profile_user.getPhoto());
    }
}
