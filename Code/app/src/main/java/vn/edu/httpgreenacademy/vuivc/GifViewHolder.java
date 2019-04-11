package vn.edu.httpgreenacademy.vuivc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class GifViewHolder extends RecyclerView.ViewHolder {
    Activity activity;

    ImageView previewImage;
    GifView gifView;

    GifViewHolder(View itemView, Activity activity) {
        super(itemView);

        this.activity = activity;

        previewImage = (ImageView) itemView.findViewById(R.id.preview_image_gif_item);
        gifView = (GifView) itemView.findViewById(R.id.gif_view_item);
    }

    void bind(final Gif gif) {
        Glide.with(itemView.getContext()).load(gif.getPreviewImageUrl()).fitCenter().into(previewImage);
        gifView.setVisibility(View.VISIBLE);
        gifView.start(gif.getPreviewMp4Url());

        gifView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                gifView.release();
                gifView.setVisibility(View.GONE);
            }
        });
        previewImage.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                gifView.setVisibility(View.VISIBLE);
                gifView.start(gif.getPreviewMp4Url());
            }
        });
    }

    public void stopPlayback() {
        if (gifView.getVisibility() == View.VISIBLE) {
            gifView.release();
            gifView.setVisibility(View.GONE);
        }
    }
}
