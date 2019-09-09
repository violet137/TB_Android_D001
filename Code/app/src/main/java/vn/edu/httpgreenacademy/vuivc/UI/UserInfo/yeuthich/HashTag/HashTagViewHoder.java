package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HashTag;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import vn.edu.httpgreenacademy.vuivc.R;

public class HashTagViewHoder extends RecyclerView.ViewHolder {
    ImageView imgAnh;
    View itemView;
    public HashTagViewHoder(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        imgAnh = itemView.findViewById(R.id.imgHinhAnhHashtag);

    }
    public void setdataHashtag(HashtagModel hashtagModel)
    {
        imgAnh.setImageResource(hashtagModel.duongdanhinh);
    }
}
