package vn.edu.httpgreenacademy.vuivc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class GifViewHolder extends RecyclerView.ViewHolder {
    Activity activity;

<<<<<<< HEAD
    View clickView;
=======
>>>>>>> fa1bde0819fdd6b8df11f95311319189f5f0f0eb
    ImageView previewImage;
    GifView gifView;

    GifViewHolder(View itemView, Activity activity) {
        super(itemView);

        this.activity = activity;

<<<<<<< HEAD
        clickView = itemView.findViewById(R.id.touch_effect_item);
=======
>>>>>>> fa1bde0819fdd6b8df11f95311319189f5f0f0eb
        previewImage = (ImageView) itemView.findViewById(R.id.preview_image_gif_item);
        gifView = (GifView) itemView.findViewById(R.id.gif_view_item);
    }

    void bind(final Gif gif) {
<<<<<<< HEAD
        Glide.with(itemView.getContext()).load(gif.getPreviewImageUrl()).centerCrop().into(previewImage);
        gifView.setVisibility(View.VISIBLE);
        gifView.start(gif.getPreviewMp4Url());

        clickView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {
                if (gifView.getVisibility() == View.VISIBLE) {
                    gifView.release();
                    gifView.setVisibility(View.GONE);
                } else {
                    gifView.setVisibility(View.VISIBLE);
                    gifView.start(gif.getPreviewMp4Url());
                }
=======
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
>>>>>>> fa1bde0819fdd6b8df11f95311319189f5f0f0eb
            }
        });
    }

    public void stopPlayback() {
        if (gifView.getVisibility() == View.VISIBLE) {
<<<<<<< HEAD
            clickView.performClick();
=======
            gifView.release();
            gifView.setVisibility(View.GONE);
>>>>>>> fa1bde0819fdd6b8df11f95311319189f5f0f0eb
        }
    }
}
