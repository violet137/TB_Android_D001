package vn.edu.httpgreenacademy.vuivc.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer.DownLoadImageTask;
import vn.edu.httpgreenacademy.vuivc.Fragment.VideoPlayer.DownloadUrlForImageViewTask;
import vn.edu.httpgreenacademy.vuivc.R;

public class DiscoveryImageViewHolder extends RecyclerView.ViewHolder {

    ImageView imageViewDiscoveryImg;
    public DiscoveryImageViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageViewDiscoveryImg = itemView.findViewById(R.id.imageViewDiscoveryImg);
    }

    public void SetData(String imageUrl)
    {
        new DownloadUrlForImageViewTask(imageViewDiscoveryImg).execute(imageUrl);
    }
}
