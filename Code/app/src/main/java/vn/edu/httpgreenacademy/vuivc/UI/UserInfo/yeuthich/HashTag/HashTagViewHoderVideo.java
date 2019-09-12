package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.HashTag;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;


import vn.edu.httpgreenacademy.vuivc.R;

public class HashTagViewHoderVideo extends RecyclerView.ViewHolder {
    View itemView;
    ImageView imgvideo;
    public HashTagViewHoderVideo(@NonNull View itemView) {
        super(itemView);
        this.itemView = itemView;
        imgvideo = itemView.findViewById(R.id.imgVideoHashtag);
    }
    public void setdataVideo(HashtagModel hashtagModel)
    {
        imgvideo.setImageResource(hashtagModel.duongdanvideo);
    }
}
