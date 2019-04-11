package vn.edu.httpgreenacademy.vuivc;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    VideoView videoViewPlayer;
    View itemView;
    MediaController mediaController;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        videoViewPlayer= itemView.findViewById(R.id.videoViewPlayer);
        this.itemView = itemView;
    }

    public void SetVideoData(final VideoModel model)
    {
        if(model != null)
        {
            if(mediaController == null)
            {
                mediaController = new MediaController(itemView.getContext());
            }
            mediaController.setAnchorView(videoViewPlayer);
            videoViewPlayer.setMediaController(mediaController);
            videoViewPlayer.setVideoURI(Uri.parse(model.getVideoUrl()));
            videoViewPlayer.requestFocus();
        }
    }

}
