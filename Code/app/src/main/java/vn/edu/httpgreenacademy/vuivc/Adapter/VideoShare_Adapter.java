package vn.edu.httpgreenacademy.vuivc.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

import vn.edu.httpgreenacademy.vuivc.DialogItem;
import vn.edu.httpgreenacademy.vuivc.DialogViewHolder;
import vn.edu.httpgreenacademy.vuivc.Model.VideoShareModel;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.ViewHolder.VideoShare_ViewHolder;

public class VideoShare_Adapter extends RecyclerView.Adapter<VideoShare_ViewHolder>
{

    ArrayList<VideoShareModel> listShareModel = new ArrayList<>();
    Activity activityShare;

    public VideoShare_Adapter(ArrayList<VideoShareModel> listShareModel,Activity activityShareVideo) {
        this.listShareModel = listShareModel;
        this.activityShare = activityShareVideo;
    }

    @NonNull
    @Override
    public VideoShare_ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new VideoShare_ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_item_video_share,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VideoShare_ViewHolder videoShare_viewHolder, int i) {
       videoShare_viewHolder.SetData(listShareModel.get(i));
        if(listShareModel.get(i).getIcon_share_image() == R.drawable.icon_video_share_more)
        {
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            share.putExtra(Intent.EXTRA_SUBJECT, listShareModel.get(i).getVideo_share_name());
            share.putExtra(Intent.EXTRA_TEXT, listShareModel.get(i).getVideo_share_link());
            activityShare.startActivity(Intent.createChooser(share, listShareModel.get(i).getVideo_share_name()));
        }
        else if(listShareModel.get(i).getIcon_share_image() == R.drawable.icon_video_share_download)
        {

        }
    }

    @Override
    public int getItemCount() {
        return listShareModel.size();
    }
}
