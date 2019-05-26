package vn.edu.httpgreenacademy.vuivc.Dialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.httpgreenacademy.vuivc.Adapter.VideoShare_Adapter;
import vn.edu.httpgreenacademy.vuivc.DialogAdapter;
import vn.edu.httpgreenacademy.vuivc.DialogItem;
import vn.edu.httpgreenacademy.vuivc.Model.VideoShareModel;
import vn.edu.httpgreenacademy.vuivc.R;
import vn.edu.httpgreenacademy.vuivc.ShareDialogFragment;

public class VideoShareDialogFragment extends DialogFragment {

    public static int resourceLayout;
    public static String video_link, video_name;
    RecyclerView recyclerViewShareSocial,recyclerViewShareDuet;
    ArrayList<VideoShareModel> listVideoShareSocial, listVideoShareDuet;
    VideoShare_Adapter adapterVideoSocial,adapterVideoDuet;

    public static VideoShareDialogFragment newInstance(String data,int resource_Layout,
        String video_link1,String video_name1) {
        VideoShareDialogFragment dialog = new VideoShareDialogFragment();
        Bundle args = new Bundle();
        args.putString("data", data);
        dialog.setArguments(args);
       resourceLayout = resource_Layout;
        video_link = video_link1;
        video_name = video_name1;
        return dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View dialogView= inflater.inflate(resourceLayout,null, false);

        recyclerViewShareSocial = dialogView.findViewById(R.id.recyclerViewShareSocial);
        recyclerViewShareDuet = dialogView.findViewById(R.id.recyclerViewShareDuet);

        listVideoShareSocial = new ArrayList<>();
        listVideoShareSocial.add(new VideoShareModel("Tin nhắn", video_link, video_name, R.drawable.icon_video_share_writesms));
        listVideoShareSocial.add(new VideoShareModel("Facebook", video_link, video_name, R.drawable.icon_video_share_facebook));
        listVideoShareSocial.add(new VideoShareModel("Messenger", video_link, video_name, R.drawable.icon_video_share_messenger));
        listVideoShareSocial.add(new VideoShareModel("Zalo", video_link, video_name, R.drawable.icon_video_share_zalo));
        listVideoShareSocial.add(new VideoShareModel("Twitter", video_link, video_name, R.drawable.icon_video_share_twitter));
        listVideoShareSocial.add(new VideoShareModel("Instagram", video_link, video_name, R.drawable.icon_video_share_instagram));
        listVideoShareSocial.add(new VideoShareModel("Stories", video_link, video_name, R.drawable.icon_video_share_stories));
        listVideoShareSocial.add(new VideoShareModel("SMS", video_link, video_name, R.drawable.icon_video_share_sms));
        listVideoShareSocial.add(new VideoShareModel("Email", video_link, video_name, R.drawable.icon_video_share_email));
        listVideoShareSocial.add(new VideoShareModel("Copy", video_link, video_name, R.drawable.icon_video_share_copy));
        listVideoShareSocial.add(new VideoShareModel("More", video_link, video_name, R.drawable.icon_video_share_more));
        adapterVideoSocial = new VideoShare_Adapter(listVideoShareSocial);
        recyclerViewShareSocial.setAdapter(adapterVideoSocial);
        recyclerViewShareSocial.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        listVideoShareDuet = new ArrayList<>();
        listVideoShareDuet.add(new VideoShareModel("Duet", video_link, video_name, R.drawable.icon_video_share_duet));
        listVideoShareDuet.add(new VideoShareModel("React", video_link, video_name, R.drawable.icon_video_share_react));
        listVideoShareDuet.add(new VideoShareModel("Lưu video", video_link, video_name, R.drawable.icon_video_share_download));
        listVideoShareDuet.add(new VideoShareModel("Lưu thành GIF", video_link, video_name, R.drawable.icon_video_share_gif));
        listVideoShareDuet.add(new VideoShareModel("Thêm vào ưa thích", video_link, video_name, R.drawable.icon_video_share_favourite));
        listVideoShareDuet.add(new VideoShareModel("Không quan tâm", video_link, video_name, R.drawable.icon_video_share_unlike));
        listVideoShareDuet.add(new VideoShareModel("Báo cáo", video_link, video_name, R.drawable.icon_video_share_report));
        adapterVideoDuet = new VideoShare_Adapter(listVideoShareDuet);
        recyclerViewShareDuet.setAdapter(adapterVideoDuet);
        recyclerViewShareDuet.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

        builder.setView(dialogView);
        return builder.create();
    }


}
