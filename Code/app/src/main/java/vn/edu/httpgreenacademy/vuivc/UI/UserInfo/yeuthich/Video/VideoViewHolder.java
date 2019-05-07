package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich.Video;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import vn.edu.httpgreenacademy.vuivc.R;

public class VideoViewHolder extends RecyclerView.ViewHolder {
 ImageView imgvideo;
 View itemView;
    public VideoViewHolder(View itemView) {
        super(itemView);
        this.itemView= itemView;
        imgvideo = itemView.findViewById(R.id.imgvideo);
    }
    public void setdatavideo(VideoModel video_model)
    {
        imgvideo.setImageResource(video_model.duongdanvide);
    }

}
