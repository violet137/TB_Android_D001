package vn.edu.httpgreenacademy.vuivc.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;


import vn.edu.httpgreenacademy.vuivc.ModelUser.ProfileUser;
import vn.edu.httpgreenacademy.vuivc.R;

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
