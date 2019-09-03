package vn.edu.httpgreenacademy.vuivc.Dialog;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import vn.edu.httpgreenacademy.vuivc.R;

public class VideoDetailDialogFragment extends DialogFragment {

    public static int resourceLayout;
    public static String videoLink, videoName;

    public static VideoDetailDialogFragment newInstance(int resource_Layout, String video_url,String video_name) {
        VideoDetailDialogFragment dialog = new VideoDetailDialogFragment();
        resourceLayout = resource_Layout;
        videoLink = video_url;
        videoName = video_name;
        return dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(resourceLayout,null, false);
        VideoView videoViewDetailVideo = dialogView.findViewById(R.id.videoViewDetailVideo);

        // Show video player
        videoViewDetailVideo.setVideoURI(Uri.parse(videoLink));
        videoViewDetailVideo.setVideoPath(videoLink);
        videoViewDetailVideo.start();

        builder.setView(dialogView);
        return builder.create();
    }


}
