package vn.edu.httpgreenacademy.vuivc.Dialog;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import vn.edu.httpgreenacademy.vuivc.R;

public class VideoDetailDialogFragment extends DialogFragment {

    public static int resourceLayout;
    public static String videoLink, videoName;
    MediaController mediaController;
    private int position = 0;
    VideoView videoViewDetailVideo;

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

        TextView tvDetailVideoName = dialogView.findViewById(R.id.tvDetailVideoName);
        videoViewDetailVideo = dialogView.findViewById(R.id.videoViewDetailVideo);

        tvDetailVideoName.setText(videoName);

        // Tạo bộ điều khiển
        if (mediaController == null) {
            mediaController = new MediaController(this.getContext());

            // Neo vị trí của MediaController với VideoView.
            mediaController.setAnchorView(videoViewDetailVideo);
            // Set đặt bộ điều khiển cho VideoView.
            videoViewDetailVideo.setMediaController(mediaController);
        }

        try {
             videoViewDetailVideo.setVideoURI(Uri.parse(videoLink));
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        videoViewDetailVideo.requestFocus();

        videoViewDetailVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoViewDetailVideo.seekTo(position);
                if (position == 0) {
                    videoViewDetailVideo.start();
                }

                // Khi màn hình Video thay đổi kích thước
                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {

                        // Neo lại vị trí của bộ điều khiển của nó vào VideoView.
                        mediaController.setAnchorView(videoViewDetailVideo);
                    }
                });
            }
        });

        builder.setView(dialogView);
        return builder.create();
    }

    // Khi bạn xoay điện thoại, phương thức này sẽ được gọi
    // nó lưu trữ lại ví trí file video đang chơi.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        // Lưu lại vị trí file video đang chơi.
        savedInstanceState.putInt("CurrentPosition", videoViewDetailVideo.getCurrentPosition());
        videoViewDetailVideo.pause();
    }

}
