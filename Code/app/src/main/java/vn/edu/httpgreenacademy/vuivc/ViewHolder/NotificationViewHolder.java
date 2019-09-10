package vn.edu.httpgreenacademy.vuivc.ViewHolder;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URI;

import vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer.DownloadUrlForImageViewTask;
import vn.edu.httpgreenacademy.vuivc.Model.NotificationModel;
import vn.edu.httpgreenacademy.vuivc.Model.VideoShareModel;
import vn.edu.httpgreenacademy.vuivc.R;

public class NotificationViewHolder extends RecyclerView.ViewHolder {

    TextView tvNotificationUserName,tvNotificationContent;
    ImageView imgViewNotificationAvatar;


    public NotificationViewHolder(@NonNull View itemView) {
        super(itemView);
        tvNotificationUserName = itemView.findViewById(R.id.tvNotificationUserName);
        tvNotificationContent = itemView.findViewById(R.id.tvNotificationContent);
        imgViewNotificationAvatar = itemView.findViewById(R.id.imgViewNotificationAvatar);
    }

    public void SetData(NotificationModel model)
    {
        tvNotificationUserName.setText(model.getTitle());
        tvNotificationContent.setText(model.getContent());
        //new DownloadUrlForImageViewTask(imgViewNotificationAvatar).execute(model.getImageUrl());
    }
}
