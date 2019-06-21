package vn.edu.httpgreenacademy.vuivc.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import vn.edu.httpgreenacademy.vuivc.Model.VideoShareModel;
import vn.edu.httpgreenacademy.vuivc.R;

public class VideoShare_ViewHolder extends RecyclerView.ViewHolder {

    ImageView image_share_video_item;
    TextView tv_share_video_item;

    public VideoShare_ViewHolder(@NonNull View itemView) {
        super(itemView);
        image_share_video_item = itemView.findViewById(R.id.image_share_video_item);
        tv_share_video_item = itemView.findViewById(R.id.tv_share_video_item);
    }

    public void SetData(VideoShareModel model)
    {
        tv_share_video_item.setText(model.getIcom_share_name());
        image_share_video_item.setImageResource(model.getIcon_share_image());
    }
}
