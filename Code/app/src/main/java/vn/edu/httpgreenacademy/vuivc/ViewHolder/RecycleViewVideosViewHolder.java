package vn.edu.httpgreenacademy.vuivc.ViewHolder;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;


import in.myinnos.gifimages.gif.GifView;
import in.myinnos.gifimages.model.Gif;
import in.myinnos.gifimages.task.ShareGif;
import vn.edu.httpgreenacademy.vuivc.ModelUser.ProfileUser;
import vn.edu.httpgreenacademy.vuivc.R;
import com.bumptech.glide.Glide;

public class RecycleViewVideosViewHolder extends RecyclerView.ViewHolder {
    ImageView img_photos;
    private Activity context;

    private View clickZone;
    private GifView gifView;

    public RecycleViewVideosViewHolder(@NonNull View itemView) {
        super(itemView);
        img_photos = itemView.findViewById(R.id.img_photos);
        clickZone = itemView.findViewById(R.id.touch_effect);
        gifView = itemView.findViewById(R.id.gif_view);
    }

    public void Bind(final Gif gif) {
        Glide.with(itemView.getContext()).load(gif.getPreviewImageUrl()).centerCrop().into(img_photos);
        clickZone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gifView.getVisibility() == View.VISIBLE) {
                    gifView.release();
                    gifView.setVisibility(View.GONE);
                } else {
                    gifView.setVisibility(View.VISIBLE);
                    gifView.start(gif.getPreviewMp4Url());
                }
            }
        });

    }
    public void stopPlayback() {
        if (gifView.getVisibility() == View.VISIBLE) {
            clickZone.performClick();
        }
    }
}
