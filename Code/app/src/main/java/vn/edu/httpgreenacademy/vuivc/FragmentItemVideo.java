package vn.edu.httpgreenacademy.vuivc;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class FragmentItemVideo extends Fragment {

    private static final String MY_VIDEO_POSITION = "0";
    private static final String MY_VIDEO_URL = "";
    private static final String MY_VIDEO_NAME = "";

    private int mVideoPosition;
    private String mVideoURL;
    private String mVideoName;

    static FragmentItemVideo newInstance(int num, VideoModel videoModel) {
        FragmentItemVideo f = new FragmentItemVideo();
        Bundle args = new Bundle();
        args.putInt(MY_VIDEO_POSITION, num);
        args.putString(MY_VIDEO_NAME, videoModel.getVideoName());
        args.putString(MY_VIDEO_URL, videoModel.getVideoUrl());
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mVideoPosition = getArguments() != null ? getArguments().getInt(MY_VIDEO_POSITION) : 0;
        mVideoName = getArguments() != null ? getArguments().getString(MY_VIDEO_NAME) : "";
        mVideoURL = getArguments() != null ? getArguments().getString(MY_VIDEO_URL) : "";
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View v = inflater.inflate(R.layout.fragment_item_video, container, false);
        TextView tvVideoName = v.findViewById(R.id.tvVideoName);
        final VideoView videoviewVertical = v.findViewById(R.id.videoviewVertical);
        ImageView imvMusic = v.findViewById(R.id.imvMusic);
        RotateAnimation rotate = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        rotate.setDuration(5000);
        rotate.setRepeatCount(Animation.INFINITE);
        imvMusic.startAnimation(rotate);

        tvVideoName.setText(mVideoName);
        MediaController mediaController = new MediaController(v.getContext());
        mediaController.setAnchorView(videoviewVertical);
        videoviewVertical.setMediaController(mediaController);
        videoviewVertical.setVideoURI(Uri.parse(mVideoURL));
        videoviewVertical.requestFocus();
        videoviewVertical.seekTo(1);
        return v;
    }
}
