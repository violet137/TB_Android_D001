package vn.edu.httpgreenacademy.vuivc.UI.UserInfo.yeuthich;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.VideoView;

import vn.edu.httpgreenacademy.vuivc.R;

public class Video_ViewHolder extends RecyclerView.ViewHolder {
 VideoView item_video;
 View itemView;
    public Video_ViewHolder(View itemView) {
        super(itemView);
        this.itemView= itemView;
        item_video = itemView.findViewById(R.id.item_video);
    }
    public void setdatavideo(VideoModel video_model)
    {

    }
}
